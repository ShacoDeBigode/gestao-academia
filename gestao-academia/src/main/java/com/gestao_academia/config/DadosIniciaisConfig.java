package com.gestao_academia.config;
import com.gestao_academia.model.Perfil;
import com.gestao_academia.model.Usuario;
import com.gestao_academia.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class DadosIniciaisConfig {

    @Bean
    public CommandLineRunner carregarDados(UsuarioRepository repository, PasswordEncoder encoder){
        return args -> {
            String emailTeste = "mestre@academia.com";

            if (repository.findByEmail(emailTeste).isEmpty()){
                Usuario admin = new Usuario();
                admin.setNome("Admin mestre");
                admin.setEmail(emailTeste);


                admin.setSenha(encoder.encode("admin123"));


                admin.setTipo(Perfil.ADMIN);
                admin.setStatus("ATIVO");

                repository.save(admin);
                System.out.println("Usuario mestre criado: mestre@academia.com / senha: admin123");
            }else {
                System.out.println("O usuario mestre ja existe no banco.");
            }
        };
    }
}
