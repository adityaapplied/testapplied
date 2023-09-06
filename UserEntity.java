@Entity
@Table(name = "user")
@Data
@EqualsAndHashCode(of = "email")
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  @Column(columnDefinition = "BINARY(16)")
  private UUID id;

  @Column(name = "email")
  private String email;

  @Column(name = "password")
  private String password;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "enabled")
  private Boolean enabled;

  @Column(name = "registration_date")
  @CreationTimestamp
  private Instant registrationDate;

  @ManyToMany(mappedBy = "users")
  @ToString.Exclude
  @JsonIgnore
  private Set<AssessmentEntity> assessments = new HashSet<>();

}
