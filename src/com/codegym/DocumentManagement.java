package com.codegym;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DocumentManagement {
    public static Scanner scanner = new Scanner(System.in);
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

    public void addNewDocument(Document newDocument) {
        documents.add(newDocument);
    }

    public void displayAllDocuments() {
        for (int i = 0; i < documents.size(); i++) {
            System.out.println((i + 1) + ". " + documents.get(i));
        }
    }

    public int findCodeDocument(int documentCode) {
        int index = -1;
        for (int i = 0; i < documents.size(); i++) {
            if (documents.get(i).getDocumentCode() == documentCode) {
                index = i;
            }
        }
        return index;
    }

    public void writeToFiles(String path) throws IOException {
        FileWriter fileWriter = new FileWriter(path);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for (Document document : documents) {
            bufferedWriter.write(document.toString() + "\n");
        }
        bufferedWriter.close();
        fileWriter.close();
    }

    public void readFiles(String path) throws IOException {
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            String[] lines = line.split(",");
            int size = lines.length;
            if (size == 5){
                int documentCode = Integer.parseInt(lines[0].trim());
                String imprint = lines[1].trim();
                int releaseNumber = Integer.parseInt(lines[2].trim());
                String nameOfWriter = lines[3].trim();
                int totalPages = Integer.parseInt(lines[4].trim());
                Document document = new Book(documentCode,imprint,releaseNumber,nameOfWriter,totalPages);
                int issueNumber  = Integer.parseInt(lines[3].trim());
                int releaseMonth  = Integer.parseInt(lines[4].trim());
                document = new Magazine(documentCode,imprint,releaseNumber,issueNumber,releaseMonth);
                this.documents.add(document);
            }
            if (size == 4) {
                int documentCode = Integer.parseInt(lines[0].trim());
                String imprint = lines[1].trim();
                int releaseNumber = Integer.parseInt(lines[2].trim());
                int releaseDate = Integer.parseInt(lines[3].trim());
                Document document = new NewsPaper(documentCode,imprint,releaseNumber,releaseDate);
                this.documents.add(document);
            }

        }
        bufferedReader.close();
        fileReader.close();
    }
//    public void readFiles1(String path) throws IOException {
//        FileReader fileReader = new FileReader(path);
//        BufferedReader bufferedReader = new BufferedReader(fileReader);
//        String line = null;
//        while ((line = bufferedReader.readLine()) != null) {
//            String[] lines = line.split(",");
//            int documentCode = Integer.parseInt(lines[0].trim());
//            String imprint = lines[1].trim();
//            int releaseNumber = Integer.parseInt(lines[2].trim());
//            int releaseDate = Integer.parseInt(lines[3].trim());
//            Document document = new NewsPaper(documentCode,imprint,releaseNumber,releaseDate);
//            this.documents.add(document);
//        }
//        bufferedReader.close();
//        fileReader.close();
//    }
//    public void readFiles2(String path) throws IOException {
//        FileReader fileReader = new FileReader(path);
//        BufferedReader bufferedReader = new BufferedReader(fileReader);
//        String line = null;
//        while ((line = bufferedReader.readLine()) != null) {
//            String[] lines = line.split(",");
//            int documentCode = Integer.parseInt(lines[0].trim());
//            String imprint = lines[1].trim();
//            int releaseNumber = Integer.parseInt(lines[2].trim());
//            int issueNumber  = Integer.parseInt(lines[3].trim());
//            int releaseMonth  = Integer.parseInt(lines[4].trim());
//            Document document = new Magazine(documentCode,imprint,releaseNumber,issueNumber,releaseMonth);
//            this.documents.add(document);
//        }
//        bufferedReader.close();
//        fileReader.close();
//    }


    public void menu() {
        System.out.println("----MENU QUẢN LÝ TÀI LIỆU----");
        System.out.println("1. Hiển thị tất cả tài liệu");
        System.out.println("2. Nhập thông tin  tài liệu mới");
        System.out.println("3. Tìm kiếm tài liệu theo mã số");
        System.out.println("4. Thoát");
    }

    public Book inputNewBook() {
        System.out.println("Mã tài liệu: ");
        int documentCode = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Tên nhà xuát bản: ");
        String imprint = scanner.nextLine();
        System.out.println("Số bản phát hành: ");
        int releaseNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Tên tác giả: ");
        String nameOfWriter = scanner.nextLine();
        System.out.println("Tổng số trang: ");
        int totalPages = scanner.nextInt();
        return new Book(documentCode, imprint, releaseNumber, nameOfWriter, totalPages);
    }

    public Magazine inputNewMagazine() {
        System.out.println("Mã tài liệu: ");
        int documentCode = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Tên nhà xuát bản: ");
        String imprint = scanner.nextLine();
        System.out.println("Số bản phát hành: ");
        int releaseNumber = scanner.nextInt();
        System.out.println("Số phát hành: ");
        int issueNumber = scanner.nextInt();
        System.out.println("Tháng phát hành: ");
        int releaseMonth = scanner.nextInt();
        return new Magazine(documentCode, imprint, releaseNumber, issueNumber, releaseMonth);

    }

    public NewsPaper inputNewPaper() {
        System.out.println("Mã tài liệu: ");
        int documentCode = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Tên nhà xuát bản: ");
        String imprint = scanner.nextLine();
        System.out.println("Số bản phát hành: ");
        int releaseNumber = scanner.nextInt();
        System.out.println("Ngày phát hành: ");
        int releaseDate = scanner.nextInt();
        return new NewsPaper(documentCode, imprint, releaseNumber, releaseDate);
    }

    public Document creatNewDocument() {
        System.out.println("1. Sách.");
        System.out.println("2. Tạp chí");
        System.out.println("3. Báo");
        System.out.println("Bạn hãy lụa chọn: ");
        int choice = scanner.nextInt();
        Document newDocument;
        switch (choice) {
            case 1: {
                System.out.println("----Thêm Sách----");
                newDocument = inputNewBook();
                break;
            }
            case 2: {
                System.out.println("----Thêm tạp chí----");
                newDocument = inputNewMagazine();
                break;
            }
            default: {
                System.out.println("----Thêm Báo----");
                newDocument = inputNewPaper();
                break;
            }
        }
        return newDocument;
    }
}
