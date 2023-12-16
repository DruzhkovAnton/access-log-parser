package ru.courses.parser;

public class UserAgent {
    String operationSystem;
    String browser;

    public UserAgent(String userAgent){
        String[] parts = userAgent.split(" ");
        if (userAgent.contains("Windows")) {
            this.operationSystem = "Windows";
        } else if (userAgent.contains("Macintosh") || userAgent.contains("Mac OS")) {
            this.operationSystem = "macOS";
        } else if (userAgent.contains("Linux")) {
            this.operationSystem = "Linux";
        } else {
            this.operationSystem = "Other";
        }

        if (userAgent.contains("Edg") || userAgent.contains("Edge")) {
            this.browser = "Edge";
        } else if (userAgent.contains("Firefox")) {
            this.browser = "Firefox";
        } else if (userAgent.contains("Chrome")) {
            if (!userAgent.contains("Edg/")) {
            this.browser = "Chrome";
            }
        } else if (userAgent.contains("Opera") || userAgent.contains("OPR")) {
            this.browser = "Opera";
        } else if (userAgent.contains("Safari") && !userAgent.contains("Chrome") && !userAgent.contains("Edge")) {
            this.browser = "Safari";
        } else {
            this.browser = "Other";
        }



    }
    public String getOperatingSystem() {
        return operationSystem;
    }

    public String getBrowser() {
        return browser;
    }


}
