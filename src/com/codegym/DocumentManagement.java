package com.codegym;

import java.util.ArrayList;

public class DocumentManagement {
    private ArrayList<Document> documents = new ArrayList<>();

    public DocumentManagement() {
    }

    public DocumentManagement(ArrayList<Document> documents) {
        this.documents = documents;
    }

    public ArrayList<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(ArrayList<Document> documents) {
        this.documents = documents;
    }
    public void addNewDocument(Document newDocument){
        documents.add(newDocument);
    }
    public void displayAllDocuments(){
        for (int i = 0; i < documents.size(); i++) {
            System.out.println((i+1)+ ". "+documents.get(i));
        }
    }
    public int findCodeDocument(int documentCode){
        int index = -1;
        for (int i = 0; i < documents.size(); i++) {
            if (documents.get(i).getDocumentCode() == documentCode){
                index = i ;
            }
        }
        return index;
    }
}
