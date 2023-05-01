package org.example;

public class author {
    String authorname;
    String authorpenname;


    public String getAuthorname() {
        return authorname;
    }

    public void setAuthorname(String authorname) {
        this.authorname = authorname;
    }

    public String getAuthorpenname() {
        return authorpenname;
    }

    public void setAuthorpenname(String authorpenname) {
        this.authorpenname = authorpenname;
    }

    @Override
    public String toString() {
        return "author{" +
                "authorname='" + authorname + '\'' +
                ", authorpenname='" + authorpenname + '\'' +
                '}';
    }
}


