
import config.AppConfig;
import controller.PostController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.PostService;

public class Main {
    public static void main(String[] args) {
        // отдаём список пакетов, в которых нужно искать аннотированные классы
        final var context = new AnnotationConfigApplicationContext(AppConfig.class);

        // получаем по классу бина
        final var controller = context.getBean(PostController.class);
        final var service = context.getBean(PostService.class);

        // по умолчанию создаётся лишь один объект на BeanDefinition
        final var isSame = service == context.getBean(PostService.class);
    }
}