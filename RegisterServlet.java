package com.example.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import com.mongodb.client.model.Filters;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private static final String URI = "mongodb+srv://esanchezs:rRMQHXnCnraPQPr3@prograii.eo98oqd.mongodb.net/";
    private static final String DB_NAME = "db_authentication";
    private static final String COLLECTION_NAME = "users";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        if(userName == null || userName.isEmpty() || password == null || password.isEmpty() || email == null || email.isEmpty()){
            response.sendRedirect("register.jsp?error=empty_fields");
            return;
        }

        try (MongoClient client = MongoClients.create(URI)) {
            MongoDatabase database = client.getDatabase(DB_NAME);
            MongoCollection<Document> collection = database.getCollection(COLLECTION_NAME);

            Document existingUser = collection.find(
                Filters.or(
                    Filters.eq("username", userName),
                    Filters.eq("email", email)
                )
            ).first();

            if(existingUser != null){
                response.sendRedirect("register.jsp?error=user_exists");
                return;
            }

            Document newUser = new Document()
                .append("username", userName)
                .append("password", password)
                .append("email", email)
                .append("rol", "consulta");
            
            collection.insertOne(newUser);

            response.sendRedirect("index.jsp?success=register_success");

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("register.jsp?error=server_error");
        }
    }
}
