package airbnb;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class TextJustication {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new LinkedList<>();
        int index = 0;
        while (index < words.length) {
            // Put first word in
            List<String> line = new ArrayList<>();
            int lineLen = words[index].length();
            line.add(words[index++]);

            // We need number of word - 1 spaces
            while (index < words.length && lineLen + words[index].length() + line.size() <= maxWidth) {
                // Add space then actual word
                lineLen += words[index].length();
                line.add(words[index++]);
            }

            StringBuilder sb = new StringBuilder();
            if (index == words.length || line.size() == 1) { // last line or just one word
                String last = String.join(" ", line);
                sb.append(last);
                for (int i = 0; i < maxWidth - last.length(); i++) {
                    sb.append(" ");
                }
                res.add(sb.toString());
            } else {
                int spacesNeeded = maxWidth - lineLen;

                int spaces = spacesNeeded / (line.size() - 1);
                int reminder = spacesNeeded % (line.size() - 1);
                for (int i = 0; i < line.size() - 1; i++) {
                    sb.append(line.get(i));
                    for (int j = 0; j < spaces + (i < reminder ? 1 : 0); j++) {
                        sb.append(" ");
                    }
                }
                sb.append(line.get(line.size()-1));
                res.add(sb.toString());
            }
        }
        return res;
    }
}
