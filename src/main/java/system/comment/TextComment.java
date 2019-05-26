package system.comment;

import system.users.User;

public class TextComment extends Comment<String> {

    public TextComment(User creatorName, String content) {
        super(creatorName, content);
    }
}
