package fr.unice.polytech.polynews;

/**
 * @author Alexandre Clement
 *         Created the 29/03/2017.
 */

public class News {
    private final int id;
    private final String title;
    private final Content content;
    private final Author author;
    private final Date date;
    private final Category category;
    private final Type type;
    private final String url;

    public News(int id, String title, Content content, Author author, Date date, Category category, Type type, String url) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.date = date;
        this.category = category;
        this.type = type;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Content getContent() {
        return content;
    }

    public Author getAuthor() {
        return author;
    }

    public Date getDate() {
        return date;
    }

    public Category getCategory() {
        return category;
    }

    public Type getType() {
        return type;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return String.format("News %s : title = \"%s\"", id, title);
    }

    public static enum Category
    {
        SOCIETY,
        POLITIC;

        public static Category valueOf(int index)
        {
            if (index <= values().length)
                return values()[index - 1];
            return null;
        }
    }

    public static enum Type
    {
        IMAGE,
        VIDEO;

        public static Type valueOf(int index)
        {
            if (index <= values().length)
                return values()[index];
            return null;
        }
    }

    public static class Content
    {
        private String text;

        public Content(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }

        @Override
        public String toString() {
            return String.format("Content : \n\t%s\n", text);
        }
    }

    public static class Author
    {
        private String name;

        public Author(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static class Date
    {
        private final String text;

        public Date(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }

        @Override
        public String toString() {
            return text;
        }
    }
}
