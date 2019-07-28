package f2019.problem468;

class Solution {
    public String validIPAddress(String ip) {
        if (ip.contains(".")) {
            // IPv4
            String[] ipGroups = ip.split("\\.", -1);
            if (ipGroups.length != 4) return "Neither";
            for (String subIp : ipGroups) {
                if (subIp.length() == 0 || subIp.length() > 3) return "Neither";
                if (!subIp.matches("^[0-9]*$")) return "Neither";
                int value = Integer.valueOf(subIp);
                if (value > 255) return "Neither";
                if (!subIp.equals(Integer.toString(value))) return "Neither";
            }
            return "IPv4";
        } else if (ip.contains(":")) {
            // IPv6
            String[] ipGroups = ip.split(":", -1);
            if (ipGroups.length != 8) return "Neither";
            for (String subIp : ipGroups) {
                if (subIp.length() > 4 || subIp.length() == 0) return "Neither";
                if (!subIp.matches("^[a-fA-F0-9]*$")) return "Neither";
            }
            return "IPv6";

        } else {
            return "Neither";
        }
    }
}