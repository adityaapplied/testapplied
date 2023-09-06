@Slf4j
@RestController
@RequestMapping("/v1")
public Class UserController {

  private UserService userService;
  private UserRepository userRepository;

  @Autowired
  public UserController(UserService userService, UserRepository userRepository) {
    this.userService = userService;
    this.userRepository=userRepository;
  }

  @PostMapping("/registrations")
  public ResponseEntity<?> createUser(@RequestBody User user) {
    User savedUser = UserService.createUser(user);
    return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
  }

  @GetMapping("/users/{id}")
  public ResponseEntity<?> getUserById(@PathVariable("id") UUID id) {
    Optional<User> optionalUser;
    try {
      optionalUser = userRepository.findById(id);
    } catch (Exception e) {
      throw new ResourceNotFoundException("User not found");
    }
    return optionalUser.get();
  }
}
