package uk.co.telecom.app.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * A Phone.
 */
@Entity
@Table(name = "phone")
@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Phone implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "phone")
    private String phone;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "create_date")
    private LocalDate createDate;

    @Column(name = "update_date")
    private LocalDate updateDate;

    /*@ManyToOne
    @JsonIgnoreProperties("phones")
    @JoinColumn(name = "customer_id")
    private Customer customer;*/

    private Long customerId;
}
