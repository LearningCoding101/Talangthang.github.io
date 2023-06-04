package Talangthang.com.project;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
/*@Table(name = "PlaceType")*/
public class PlaceType {
    @Id
    @Column(name = "TypeID", length = 3)
    private String typeId;

    @Column(name = "TypeName", length = 30)
    private String typeName;

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public PlaceType() {
    }

    @Override
    public String toString() {
        return "PlaceType{" +
                "typeId='" + typeId + '\'' +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
