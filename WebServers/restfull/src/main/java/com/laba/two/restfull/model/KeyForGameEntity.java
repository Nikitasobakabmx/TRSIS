package com.laba.two.restfull.model;

import javax.persistence.*;

@Entity
@Table(name = "key_for_game", schema = "public", catalog = "game_shop")
public class KeyForGameEntity {
    private long key;
    private Boolean isUsed;
    private String keyHolder;

    @Id
    @Column(name = "key", nullable = false)
    public long getKey() {
        return key;
    }

    public void setKey(long key) {
        this.key = key;
    }

    @Basic
    @Column(name = "is_used", nullable = true)
    public Boolean getUsed() {
        return isUsed;
    }

    public void setUsed(Boolean used) {
        isUsed = used;
    }

    @Basic
    @Column(name = "key_holder", nullable = true, length = 100)
    public String getKeyHolder() {
        return keyHolder;
    }

    public void setKeyHolder(String keyHolder) {
        this.keyHolder = keyHolder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KeyForGameEntity that = (KeyForGameEntity) o;

        if (key != that.key) return false;
        if (isUsed != null ? !isUsed.equals(that.isUsed) : that.isUsed != null) return false;
        if (keyHolder != null ? !keyHolder.equals(that.keyHolder) : that.keyHolder != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (key ^ (key >>> 32));
        result = 31 * result + (isUsed != null ? isUsed.hashCode() : 0);
        result = 31 * result + (keyHolder != null ? keyHolder.hashCode() : 0);
        return result;
    }
}
