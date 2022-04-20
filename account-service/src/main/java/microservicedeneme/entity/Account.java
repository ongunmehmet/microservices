package microservicedeneme.entity;

import lombok.*;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
@ToString
@Table(value = "accounts")
public class Account implements Serializable {
    @PrimaryKey
    private String id= UUID.randomUUID().toString();
    @Column(value ="uname" )
    @Setter
    private String fullName;
    @Setter
    @Column(value ="dob")
    private Date dateOfBirth;
    @Setter
    @Column(value = "email")
    private String email;
    @Setter
    @Column(value = "pwd")
    private String password;
    @Column(value = "created_at")
    private Date createdAt;
    @Column(value = "is_active")
    private boolean active;



}
