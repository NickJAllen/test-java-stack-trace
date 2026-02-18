# Keep the attributes required for stack traces
-keepattributes SourceFile,LineNumberTable

# Rename the source file to something generic 
# like "SourceFile" to hide the original filename while keeping the line numbers.
-renamesourcefileattribute SourceFile

-keep public class org.example.App {
    public static void main(java.lang.String[]);
}
