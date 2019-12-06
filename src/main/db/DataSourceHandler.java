package main.db;

import main.java.model.Document;
import main.java.model.Tag;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.UUID;

public class DataSourceHandler {

    private DataSource database;


    /*
    Database columns
    Documents   :   id  name    file    project
     */
    public DataSourceHandler() {
        try {
            this.database = new DataSource();
            database.go(null);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void releaseResources(Connection conn, ResultSet rs) {
        // release all open resources to avoid unnecessary memory usage

        // ResultSet
        try {
            if (rs != null) {
                rs.close();
                rs = null;
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

        //Connection
        try {
            if (conn != null) {
                conn.close();
                conn = null;
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }

    public void addDocument(Document document) {
        Connection conn = null;
        try {

            Tag<String> projectTag = document.getTag("project");

            conn = database.getConnect();
            Statement s = conn.createStatement();
            PreparedStatement psInsert = conn.prepareStatement(
                    "insert into documents values (?, ?, ?, ?)");
            psInsert.setString(1, document.getId().toString());
            psInsert.setString(2, document.getName());
            psInsert.setString(3,document.getFile().getPath());
            if (projectTag != null) {
                psInsert.setString(4, projectTag.getValue().toString());
            } else {
                psInsert.setString(4,null);
            }

            psInsert.executeUpdate();
            System.out.println("Insterted Document " + document.getName());


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            releaseResources(conn, null);
        }


    }

    public void removeDocument(Document document) {

    }

    public void updateDocument(Document document) {

    }

    public ArrayList<Document> getDocuments() {
        ResultSet results = null;
        Connection conn = null;
        ArrayList<Document> returnList = null;
        try {
            conn = database.getConnect();
            returnList = new ArrayList<Document>();
            Statement s = conn.createStatement();
            PreparedStatement psFetch = conn.prepareStatement(
                    "SELECT * FROM documents");
            results = psFetch.executeQuery();

            /*
            if (!results.next())
            {
                System.out.println("No rows in results!");
            }*/

            while (results.next()) {
                System.out.println("Begin Import");
                Document returnDoc = null;
                // Gets document values from results
                UUID resultID = UUID.fromString(results.getString("id"));
                System.out.println(resultID);
                String resultName = results.getString("name");
                System.out.println(resultName);
                File resultFile = new File(results.getString("file"));
                System.out.println(resultFile);
                Tag<String> returnProject = new Tag<String>("project", results.getString("project")) ;
                System.out.println(returnProject.getValue());
                // Returns a document object
                returnDoc = new Document(resultName, resultFile, resultID);
                System.out.println("Doc created");
                returnDoc.projectProperty().setValue(returnProject);

                returnList.add(returnDoc);

                System.out.println("Restored Document: " + returnDoc.toString());


            }



        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {

            releaseResources(conn, results);
            return returnList;
        }
    }

    public Document getDocument(UUID id) {
        ResultSet results = null;
        Connection conn = null;
        Document returnDoc = null;
        try {
            conn = database.getConnect();
            // Selects a document
            String idString = id.toString();
            Statement s = conn.createStatement();
            PreparedStatement psFetch = conn.prepareStatement(
                "SELECT id, name, file, project FROM documents WHERE id = ?");
            psFetch.setString(1,idString);
            results = psFetch.executeQuery();

            // Gets document values from results
            UUID resultID = UUID.fromString(results.getString("id"));
            String resultName = results.getString("name");
            File resultFile = new File(results.getString("file"));
            Tag<String> returnProject = new Tag<String>("project", results.getString("project")) ;

            // Returns a document object
            returnDoc = new Document(resultName, resultFile, resultID);
            returnDoc.projectProperty().setValue(returnProject);

            System.out.println("Fetched Doc with ID=" + idString);
            System.out.println("New Document: " + returnDoc.toString());


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            releaseResources(conn, results);
            return returnDoc;
        }
    }
}
