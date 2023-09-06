@Slf4j
@Service
public class MessageConfirmService {

  public User createUser(User user) {
    return userRepository.save(user);
  }
}
