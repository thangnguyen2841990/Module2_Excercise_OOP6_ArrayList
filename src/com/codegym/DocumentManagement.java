package com.codegym;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
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
public void writerToFile(List<Document> documents, String path) throws IOException {
        OutputStream os = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(documents);
}
public void readerFile(String path) throws IOException, ClassNotFoundException {
        InputStream is = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(is);
        this.documents = (ArrayList<Document>) ois.readObject();
}
//    public void writeToFiles(String path) throws IOException {
//        FileWriter fileWriter = new FileWriter(path);
//        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//        for (Document document : documents) {
//            bufferedWriter.write(document.toString() + "\n");
//        }
//        bufferedWriter.close();
//        fileWriter.close();
//    }
//
//    public void readFiles(String path) throws IOException {
//        FileReader fileReader = new FileReader(path);
//        BufferedReader bufferedReader = new BufferedReader(fileReader);
//        String line = null;
//        while ((line = bufferedReader.readLine()) != null) {
//            String[] lines = line.split(",");
//            int size = lines.length;
//            if (size == 5){
//                int documentCode = Integer.parseInt(lines[0].trim());
//                String imprint = lines[1].trim();
//                int releaseNumber = Integer.parseInt(lines[2].trim());
//                String nameOfWriter = lines[3].trim();
//                int totalPages = Integer.parseInt(lines[4].trim());
//                Document document = new Book(documentCode,imprint,releaseNumber,nameOfWriter,totalPages);
//                int issueNumber  = Integer.parseInt(lines[3].trim());
//                int releaseMonth  = Integer.parseInt(lines[4].trim());
//                document = new Magazine(documentCode,imprint,releaseNumber,issueNumber,releaseMonth);
//                this.documents.add(document);
//            }
//            if (size == 4) {
//                int documentCode = Integer.parseInt(lines[0].trim());
//                String imprint = lines[1].trim();
//                int releaseNumber = Integer.parseInt(lines[2].trim());
//                int releaseDate = Integer.parseInt(lines[3].trim());
//                Document document = new NewsPaper(documentCode,imprint,releaseNumber,releaseDate);
//                this.documents.add(document);
//            }
//
//        }
//        bufferedReader.close();
//        fileReader.close();
//    }



    public void menu() {
        System.out.println("----MENU QU???N L?? T??I LI???U----");
        System.out.println("1. Hi???n th??? t???t c??? t??i li???u");
        System.out.println("2. Nh???p th??ng tin  t??i li???u m???i");
        System.out.println("3. T??m ki???m t??i li???u theo m?? s???");
        System.out.println("4. Tho??t");
    }

    public Book inputNewBook() {
        System.out.println("M?? t??i li???u: ");
        int documentCode = scanner.nextInt();
        scanner.nextLine();
        System.out.println("T??n nh?? xu??t b???n: ");
        String imprint = scanner.nextLine();
        System.out.println("S??? b???n ph??t h??nh: ");
        int releaseNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.println("T??n t??c gi???: ");
        String nameOfWriter = scanner.nextLine();
        System.out.println("T???ng s??? trang: ");
        int totalPages = scanner.nextInt();
        return new Book(documentCode, imprint, releaseNumber, nameOfWriter, totalPages);
    }

    public Magazine inputNewMagazine() {
        System.out.println("M?? t??i li???u: ");
        int documentCode = scanner.nextInt();
        scanner.nextLine();
        System.out.println("T??n nh?? xu??t b???n: ");
        String imprint = scanner.nextLine();
        System.out.println("S??? b???n ph??t h??nh: ");
        int releaseNumber = scanner.nextInt();
        System.out.println("S??? ph??t h??nh: ");
        int issueNumber = scanner.nextInt();
        System.out.println("Th??ng ph??t h??nh: ");
        int releaseMonth = scanner.nextInt();
        return new Magazine(documentCode, imprint, releaseNumber, issueNumber, releaseMonth);

    }

    public NewsPaper inputNewPaper() {
        System.out.println("M?? t??i li???u: ");
        int documentCode = scanner.nextInt();
        scanner.nextLine();
        System.out.println("T??n nh?? xu??t b???n: ");
        String imprint = scanner.nextLine();
        System.out.println("S??? b???n ph??t h??nh: ");
        int releaseNumber = scanner.nextInt();
        System.out.println("Ng??y ph??t h??nh: ");
        int releaseDate = scanner.nextInt();
        return new NewsPaper(documentCode, imprint, releaseNumber, releaseDate);
    }

    public Document creatNewDocument() {
        System.out.println("1. S??ch.");
        System.out.println("2. T???p ch??");
        System.out.println("3. B??o");
        System.out.println("B???n h??y l???a ch???n: ");
        int choice = scanner.nextInt();
        Document newDocument;
        switch (choice) {
            case 1: {
                System.out.println("----Th??m S??ch----");
                newDocument = inputNewBook();
                break;
            }
            case 2: {
                System.out.println("----Th??m t???p ch??----");
                newDocument = inputNewMagazine();
                break;
            }
            default: {
                System.out.println("----Th??m B??o----");
                newDocument = inputNewPaper();
                break;
            }
        }
        return newDocument;
    }
}
