import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class CityAnotherCodility {
    public static class Photo {
        String name;
        String location;
        Date date;

        public Photo(String name, String location, Date date) {
            this.name = name;
            this.location = location;
            this.date = date;
        }
    }

    public static String solution(String S){
        // write your code in Java SE 8
        String result="";
        // Parsing the photos and storing them in a HashMap.
        // The HashMap is storing them as <Country - List of Photos>
        try {
            String[] photos = S.split("\\n");
            HashMap<String, String> resultMap = new HashMap<>();
            HashMap<String, List<Photo>> sortMap = new HashMap<>();
            DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            for (String photo : photos) {
                String[] details = photo.trim().split(",");
                String date = details[2].trim();
                Date d2 = df2.parse(date);
                String photoName = details[0].trim();
                String location=details[1].trim();
                Photo ph = new Photo(photoName,location,d2);
                List<Photo> list;

                if (!sortMap.containsKey(location)) {
                    list = new ArrayList<>();
                }else{
                    list = sortMap.get(location);
                }
                list.add(ph);
                sortMap.put(location, list);
                resultMap.put(photo, photo);
            }

            //Sort the photos basis Date and Time
            for (List<Photo> list : sortMap.values()) {
                Collections.sort(list, new Comparator<Photo>() {
                    @Override
                    public int compare(Photo o1, Photo o2) {
                        return o1.date.compareTo(o2.date);
                    }
                });
            }


            // Forming the new name here
            for (String country : sortMap.keySet()) {
                List<Photo> photoList = sortMap.get(country);
                int count = 0;
                int size = photoList.size();
                int total_length = String.valueOf(size).length();
                for (Photo newPhoto : photoList) {
                    count = count + 1;
                    for (String photo : photos) {
                        String details[] = photo.split(",");
                        String photoName=details[0].trim();
                        String location =details[1].trim();

                        if (photoName.equals(newPhoto.name) && location.equals(country)) {
                            int ext_index = photoName.indexOf('.');
                            String extension = photoName.substring(ext_index);
                            int len_count = String.valueOf(count).length();

                            String cnt = Integer.valueOf(count).toString();
                            if (total_length > len_count) {
                                cnt = populateZeroes(total_length, len_count, count);
                            }
                            String newName = country.concat(cnt).concat(extension);
                            resultMap.put(photo, newName);
                            break;
                        }
                    }

                }
            }

            StringBuilder stringBuilder = new StringBuilder();
            for (String photo : photos) {
                stringBuilder.append(resultMap.get(photo));
                stringBuilder.append("\n");
            }

            result=stringBuilder.toString();
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public static String populateZeroes(int totalLength, int photoCount, int count){
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append(count);
        int diff = totalLength-photoCount;

        for(int i=1;i<=diff;i++){
            stringBuilder.insert(0,'0');
        }

        return stringBuilder.toString();
    }

    public static void main(String args[]) throws Exception{
        String string="photo.jpg, Warsaw, 2013-09-05 14:08:15\njohn.png, London, 2015-06-20 15:13:22\nmyFriends.png, Warsaw, 2013-09-05 14:07:13\nEiffel.jpg, Paris, 2015-07-23 08:03:02\npisatower.jpg, Paris, 2015-07-22 23:59:59\nBOB.jpg, London, 2015-08-05 00:02:03\nnotredame.png, Paris, 2015-09-01 12:00:00\nme.jpg, Warsaw, 2013-09-06 15:40:22\na.png, Warsaw, 2016-02-13 13:33:50\nb.jpg, Warsaw, 2016-01-02 15:12:22\nc.jpg, Warsaw, 2016-01-02 14:34:30\nd.jpg, Warsaw, 2016-01-02 15:15:01\ne.png, Warsaw, 2016-01-02 09:49:09\nf.png, Warsaw, 2016-01-02 10:55:32\ng.jpg, Warsaw, 2016-02-29 22:13:11\nphoto12.jpg, Warsaw, 2013-09-09 14:08:15\nphoto12.jpg, Warsaw, 2013-09-09 14:08:15\nphoto12.jpg, Paris, 2013-09-09 14:08:15\nphoto13.jpg, Paris, 2012-09-09 14:08:15\nphoto14.jpg, Paris, 2017-09-09 14:08:15\nphoto15.jpg, Paris, 2015-09-09 14:08:15\nphoto16.jpg, Paris, 2014-09-09 14:08:15\nphoto17.jpg, Paris, 2014-10-09 14:08:15\nphoto18.jpg, Paris, 2014-11-09 14:08:15\nphoto19.jpg, Paris, 2015-11-09 14:08:15\nphoto20.jpg, Paris, 2014-01-09 15:08:15";
        System.out.print(solution(string));
    }
}
