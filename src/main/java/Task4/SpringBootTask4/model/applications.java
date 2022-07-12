package Task4.SpringBootTask4.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table (name = "t_applications")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class applications {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "full_Name")
    private String fullName;

    @Column(name = "well")
    private String well;

    @Column(name = "telefon_Number")
    private String telefonNumber;

    @Column(name = "osnov_Text", columnDefinition = "text")
    private String osnovText;

    @Column(name = "handled")
    private boolean handled;
}