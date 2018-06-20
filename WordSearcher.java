import java.io.*;
import java.text.DecimalFormat;
import java.util.*;


public class WordSearcher {
    public static HashMap<String,Set<File>> hashMap = new HashMap<>();
    public static List<File> files = new ArrayList<>();

    public static void countFilesInDirectory(File folder) {
        if(!folder.exists()){
            throw new NullPointerException("No such directory");
        }
        System.out.println("In directory.."+folder.getName());
        File[] fileNames = folder.listFiles();
        for (File file : fileNames) {
            // if directory call the same method again
            if (file.isDirectory()) {
                countFilesInDirectory(file);
            } else {
                try {
                    files.add(file);
                    parseContent(file);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        }
    }

    //Parses the File contents-word by word and creates an inverted index representation of
    //the content. (word--><Set<File>>)

    public static void parseContent(File file) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String strLine;
            while ((strLine = br.readLine()) != null) {
                String[] strings = strLine.split(" ");
                for(String string:strings){
                    String lowerString=string.toLowerCase();
                    Set<File> stringSet;
                    if(!hashMap.containsKey(lowerString)) {
                        stringSet = new HashSet<>();
                    } else {
                        stringSet = hashMap.get(lowerString);
                    }
                    stringSet.add(file);
                    hashMap.put(lowerString,stringSet);
                }
            }
        }
    }


    public static void search(String string){
        String strings[] = string.split(" ");
        HashMap<File,Integer> stringMap = new HashMap<>();
        for(File file:files){
            stringMap.put(file,0);
        }
        for(String str:strings){
            String lowerStr=str.toLowerCase();
            //if the string to be searched is not in the HashMap,
            // it means that we wouldn't find it for any of the files.
            if(!hashMap.containsKey(lowerStr)){
                continue;
            }
            for(File file: hashMap.get(lowerStr)){
                int cnt=stringMap.get(file)+1;
                stringMap.put(file,cnt);
            }
        }
        // Creating a sortedSet which will sort the values of an Entry Object in descending order
        SortedSet<Map.Entry<File, Integer>> sortedset = new TreeSet<Map.Entry<File, Integer>>(
                new Comparator<Map.Entry<File, Integer>>() {
                    @Override
                    public int compare(Map.Entry<File, Integer> e1,
                                       Map.Entry<File, Integer> e2) {
                        int compare = e2.getValue().compareTo(e1.getValue());
                        if(compare==0){
                            return 1;
                        }
                        return compare;
                    }
                });
        //copy all HashMap entries into the sortedSet.
        sortedset.addAll(stringMap.entrySet());
        int count=1;
        DecimalFormat df = new DecimalFormat("#.##");

        for(Map.Entry<File,Integer> entry : sortedset){
            //if the first entry has count 0, it means there are no entries corresponding to the String search
            if(count>10){
                break;
            }
            if(entry.getValue()==0){
                //If the first entry has value of 0, it means that There is not a single matching word in
                //any of the files.
                if(count==1) {
                    System.out.println("No Matches found");
                }
                break;
            }else {
                float percentageMatch = (float)entry.getValue()/strings.length * 100;
                System.out.println(entry.getKey() + "-->" + df.format(percentageMatch) + "%");
            }
            count++;
        }
    }

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        if (args. length == 0 ) {
            throw new IllegalArgumentException( "No directory given to index." );
        }
        // stringBuilder.append(args[0]+" ");
        //stringBuilder.append(args[1]);
        // System.out.print(stringBuilder.toString().trim());
        // System.out.println(args[0]);
        //System.out.println(args[1]);
        File folder = new File(args[0]);
        countFilesInDirectory(folder);
        System.out.println(files.size() + " files in directory "+folder.getName());

        //For Debugging purpose, prints the parsed file content.
       /* for(String x : hashMap.keySet()){
            System.out.print(x+"-->");
            for(File file : hashMap.get(x)){
                System.out.print(file.getName()+" ");
            }
            System.out.println();
        }*/

        System.out.println("--------------------");

        //For debugging purposes- the below line is commented
        /*String toSearch = scanner.nextLine();
        search(toSearch, files);*/

        while(true) {
            System.out.println(">search:");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(scanner.nextLine());
            String toSearch = stringBuilder.toString().trim();
            if(toSearch.equals("quit")){
                break;
            }
            System.out.println(stringBuilder.toString().trim());
            search(toSearch);
        }

    }
}
