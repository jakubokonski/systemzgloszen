package system.comment;

import system.users.User;

import java.time.LocalDateTime;

public abstract class Comment<T> {

    private User creatorName;
    private User modifiedBy;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    protected T content;

    public Comment(User creatorName, T content) {
        this.creatorName = creatorName;
        this.modifiedBy = getModifiedBy();
        this.createdAt = LocalDateTime.now();
        this.modifiedAt = LocalDateTime.now();
        this.content = content;
    }

    public void modifyComment() {

    }

    public User getCreatorName() {
        return creatorName;
    }

    public User getModifiedBy() {
        return modifiedBy;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    public T getContent() {
        return content;
    }

    public void setModifiedBy(User modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public void setModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public void changeContent(User modifiedBy, T content) {
        this.content = content;
        this.modifiedBy = modifiedBy;
        this.modifiedAt = LocalDateTime.now();

    }

    //    public static class CommentBuilder<T> {
//
//        private User creatorName;
//        private User modifiedBy;
//        private LocalDateTime createdAt;
//        private LocalDateTime modifiedAt;
//        private T content;
//
//        public CommentBuilder() {
//        }
//
//        public CommentBuilder creatorName(String creatorName) {
//            this.creatorName = creatorName;
//            return this;
//        }
//
//        public CommentBuilder modifiedBy(String modifiedBy) {
//            this.modifiedBy = modifiedBy;
//            return this;
//        }
//
//        public CommentBuilder createdAt(LocalDateTime createdAt) {
//            this.createdAt = createdAt;
//            return this;
//        }
//
//        public CommentBuilder modifiedAt(LocalDateTime modifiedAt) {
//            this.modifiedAt = modifiedAt;
//            return this;
//        }
//
//        public CommentBuilder content(T content) {
//            this.content = content;
//            return this;
//        }
//
//        public Comment build() {
//            return new Comment(this);
//        }

//    }

}
