package system.comment;

import java.time.LocalDateTime;

public abstract class Comment<T> {

    private String creatorName;
    private String modifiedBy;
    private LocalDateTime created;
    private LocalDateTime lastModified;
    private T text;


    public void modifyComment() {

    }

    public String getCreatorName() {
        return creatorName;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public LocalDateTime getLastModified() {
        return lastModified;
    }

    public T getText() {
        return text;
    }

    public static class CommentBuilder<T> {

        private String creatorName;
        private String modifiedBy;
        private LocalDateTime created;
        private LocalDateTime lastModified;
        private T text;

        public CommentBuilder() {
        }

        public CommentBuilder creatorName(String creatorName) {
            this.creatorName = creatorName;
            return this;
        }

        public CommentBuilder modifiedBy(String modifiedBy) {
            this.modifiedBy = modifiedBy;
            return this;
        }

        public CommentBuilder created(LocalDateTime created) {
            this.created = created;
            return this;
        }

        public CommentBuilder lastModified(LocalDateTime lastModified) {
            this.lastModified = lastModified;
            return this;
        }

        public CommentBuilder text(T text) {
            this.text = text;
            return this;
        }

    }

}
