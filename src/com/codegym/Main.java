package com.codegym;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = -1;
        DocumentManagement documentManagement = new DocumentManagement();
        try {
            documentManagement.readFiles("document.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        do {
            documentManagement.menu();
            System.out.println("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();
            if (choice > 3) {
                System.out.println("chọn lại Menu!!!!");
            }
            switch (choice) {
                case 1: {
                    System.out.println("Danh sách tài liệu");
                    int size = documentManagement.getDocuments().size();
                    if (size == 0){
                        System.out.println("Không có tài liệu nào để hiển thị!");
                    }else {
                        documentManagement.displayAllDocuments();

                    }
                    break;
                }

                case 2: {
                    System.out.println("----Nhập thông tin mới cho tài liệu");
                    Document newDocument;
                    newDocument = documentManagement.creatNewDocument();
                    documentManagement.addNewDocument(newDocument);
                    System.out.println("Đã thêm tài liệu thành công!");
                    break;
                }
                case 3: {
                    System.out.println("----Tìm kiếm tài liệu theo mã số tài liệu----");
                    System.out.println("Nhập mã số tài liệu cần tìm: ");
                    int documentCode = scanner.nextInt();
                    int index = documentManagement.findCodeDocument(documentCode);
                    if (index == -1) {
                        System.out.println("Không tìm thấy tài liệu có mã số: " + documentCode);
                    } else {
                        System.out.println(documentManagement.getDocuments().get(index));
                    }
                    break;
                }
            }
            try {
                documentManagement.writeToFiles("document.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while (choice != 4);
    }



}
