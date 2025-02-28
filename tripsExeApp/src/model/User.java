package model;

import java.util.Date;
import java.util.List;

public class User {

    private String userId;
    private String username;
    private String password;
    private String email;
    private String avatar;
    private List<String> postIds;
    private List<String> friends;
    private Date premiumExpirationDate;
    private boolean premiumAccount;
    private List<String> notifyIds;

    public User() {
    }

    public User(String userId, String username, String password, String email, String avatar, List<String> postIds, List<String> friends, Date premiumExpirationDate, boolean premiumAccount, List<String> notifyIds) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.avatar = avatar;
        this.postIds = postIds;
        this.friends = friends;
        this.premiumExpirationDate = premiumExpirationDate;
        this.premiumAccount = premiumAccount;
        this.notifyIds = notifyIds;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public List<String> getPostIds() {
        return postIds;
    }

    public void setPostIds(List<String> postIds) {
        this.postIds = postIds;
    }

    public List<String> getFriends() {
        return friends;
    }

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }

    public Date getPremiumExpirationDate() {
        return premiumExpirationDate;
    }

    public void setPremiumExpirationDate(Date premiumExpirationDate) {
        this.premiumExpirationDate = premiumExpirationDate;
    }

    public boolean isPremiumAccount() {
        return premiumAccount;
    }

    public void setPremiumAccount(boolean premiumAccount) {
        this.premiumAccount = premiumAccount;
    }

    public List<String> getNotifyIds() {
        return notifyIds;
    }

    public void setNotifyIds(List<String> notifyIds) {
        this.notifyIds = notifyIds;
    }

}
