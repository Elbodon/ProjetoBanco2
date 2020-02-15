package br.edu.ifpb.model.dao;

import br.edu.ifpb.model.impl.Produto;
import com.mongodb.client.*;
import org.bson.conversions.Bson;

import javax.swing.text.Document;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.function.Consumer;

public class ProdutoDAOMongo implements ProdutoDAO {


    @Override
    public boolean adicionarProduto(Produto produto) throws SQLException, ClassNotFoundException {

        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase banco = mongoClient.getDatabase("Produto");
            MongoCollection collection = banco.getCollection("produto");


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

            MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
            MongoDatabase banco = mongoClient.getDatabase("Produto");
            MongoCollection collection = banco.getCollection("produto");
            ArrayList<Produto> produtoArrayList = new ArrayList<>();

            MongoIterable<Document> documents = collection.find();
            documents.forEach((Consumer<? super Document>)
            document -> produtoArrayList.add((new Produto().fromDocument((org.bson.Document) document))));
            return produtoArrayList;

    }

}

