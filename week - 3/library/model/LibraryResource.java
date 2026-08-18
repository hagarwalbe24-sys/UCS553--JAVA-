package library.model;

public abstract class LibraryResource {
    private int resourceId;
    private String title;
    private String author;
    protected static String libraryName = "University Smart Library";
    private static int resourceCount = 0;

    public LibraryResource(int resourceId, String title, String author) {
        this.resourceId = resourceId;
        this.title = title;
        this.author = author;
        resourceCount++;
    }

    public int getResourceId() { return resourceId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }

    protected void showBasicDetails() {
        System.out.println("Library: " + libraryName);
        System.out.println("Resource ID: " + resourceId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }

    public abstract double calculateFine(int overdueDays);

    public static void displayTotalResources() {
        System.out.println("Total resources created: " + resourceCount);
    }
}
