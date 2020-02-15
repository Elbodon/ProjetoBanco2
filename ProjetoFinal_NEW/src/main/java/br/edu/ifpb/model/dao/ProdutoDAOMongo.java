package br.edu.ifpb.model.dao;

import br.edu.ifpb.model.impl.Produto;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.conversions.Bson;

import javax.swing.text.Document;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ProdutoDAOMongo implements ProdutoDAO {


    @Override
    public boolean adicionarProduto(Produto produto) throws SQLException, ClassNotFoundException {

        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase banco = mongoClient.getDatabase("Produto");
            MongoCollection collection = banco.getCollection("produto");

            //Inserção
            collection.insertOne(new Produto(produto.getId(),produto.getNome(),produto.getPreco(),produto.getQuantidade())
                    .toDocument());
            return true;
        }
    }

    @Override
    public boolean removerProduto(Produto produto) throws SQLException, ClassNotFoundException {

        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase banco = mongoClient.getDatabase("Produto");
            MongoCollection collection = banco.getCollection("produto");

            //Remove
            collection.findOneAndDelete((Bson) produto);
            return true;
        }

    }

    @Override
    public ArrayList buscarProduto(String nomeProduto) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList listarProduto() throws SQLException, ClassNotFoundException {
        return null;
    }

}

