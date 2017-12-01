package model;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Book implements Externalizable {
    private String name;
    private String author;
    private String publisher;
    private int publishingYear;
    private int pageCount;
    private int price;

    public Book() {
        name = "Название книги";
        author = "Имя Фамилия";
        publisher = "Название публикации";
        publishingYear = 1000;
        pageCount = 100;
        price = 500;
    }

    Book(String name, String author, String publisher, int publishingYear, int pageCount, int price) {
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.publishingYear = publishingYear;
        this.pageCount = pageCount;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPublishingYear() {
        return publishingYear;
    }

    public void setPublishingYear(int publishingYear) {
        this.publishingYear = publishingYear;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return author + " \"" + name + "\", " + publishingYear + " год\n"
                + publisher + ", " + pageCount + " стр., " + price + "грн.";
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(name);
        out.writeUTF(author);
        out.writeUTF(publisher);
        out.writeInt(publishingYear);
        out.writeInt(pageCount);
        out.writeInt(price);
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = in.readUTF();
        author = in.readUTF();
        publisher = in.readUTF();
        publishingYear = in.readInt();
        pageCount = in.readInt();
        price = in.readInt();
    }
}
