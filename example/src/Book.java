package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Book implements Comparable<Book>, Cloneable {
    private String title;
    private Date publishDate;
    private String comment;

    Book() {

    }

    Book(String title, Date publishDate, String comment) {
        this.title = title;
        this.publishDate = publishDate;
        this.comment = comment;
    }

    @Override
    public int hashCode() {
        return Objects.hash(comment, title);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Book other = (Book) obj;
        return Objects.equals(publishDate, other.publishDate) && Objects.equals(title, other.title);
    }

    @Override
    protected Book clone() {
        Book result = new Book();
        result.title = this.title;
        result.comment = this.comment;
        result.publishDate = this.publishDate;
        return result;
    }

    @Override
    public int compareTo(Book o) {
        if (this.publishDate.before(o.publishDate)) {
            return -1;
        }
        if (this.publishDate.after(o.publishDate)) {
            return 1;
        }
        return 0;
        // 삼항연산자로도 표현이 가능하다
        // return this.publishDate.before(o.publishDate) ? -1 :
        // this.publishDate.after(o.publishDate) ? 1 : 0;
    }

    @Override
    public String toString() {
        return String.valueOf(this.publishDate);
    }

    // 확인하는 메인메소드
    public static void main(String[] args) {
        // 1번
        Book b1 = new Book("제목1", new Date(System.currentTimeMillis()), "내용1");
        Book b2 = new Book("제목1", new Date(System.currentTimeMillis()), "내용2");
        if (b1.equals(b2)) {
            System.out.println("내용이 달라도 같다!");
        }
        
        // 2번
        Book b3 = new Book("제목3", new Date(System.currentTimeMillis() + 1000), "내용3");
        Book b4 = new Book("제목4", new Date(System.currentTimeMillis() + 2000), "내용4");
        List<Book> arr = new ArrayList<>();
        arr.add(b4);
        arr.add(b3);
        arr.add(b2);
        
        System.out.println("정렬 전 출력");
        for (Book b : arr) {
            System.out.println(b.toString());
        }
        
        System.out.println("정렬 후 출력");
        Collections.sort(arr);
        for (Book b : arr) {
            System.out.println(b.toString());
        }
        
        // 3번
        Book b5 = b1.clone();
        System.out.println(b5.title);
    }

}
