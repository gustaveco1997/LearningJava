package br.com.codenation.projetolongo.controller;

import br.com.codenation.projetolongo.domain.entity.Usuario;
import br.com.codenation.projetolongo.domain.vo.UsuarioVo;
import br.com.codenation.projetolongo.service.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/v1/Usuario")
public class UsuarioController {

    @Autowired
    UsuarioServiceImpl usuarioService;

    @GetMapping("/updateName")
    public ResponseEntity update(@PathVariable Long id, @PathVariable String nome) {
        Usuario user = new Usuario();
        user.setId(id);
        user.setName(nome);
        usuarioService.updateUser(user);

        return ResponseEntity.ok(usuarioService.findById(id));
    }

    @PostMapping("/save")
    public Usuario salvar(@RequestBody UsuarioVo usuarioVo) {
        Usuario u = Usuario.toUsuario(usuarioVo);
        return usuarioService.salvar(u);
    }

    @PostMapping("/alterarendereco")
    public Usuario alterarEndereco(@RequestBody UsuarioVo usuarioVo) {
        Usuario u = Usuario.toUsuario(usuarioVo);
        return usuarioService.salvar(u);
    }

    @PutMapping("/updatename")
    public ResponseEntity updateUsuario(@Param("id") Long id, @Param("name") String name) {
        Usuario u = new Usuario();
        u.setId(id);
        u.setName(name);
        usuarioService.updateUser(u);

        return ResponseEntity.ok(Usuario.toUsuarioVo(usuarioService.findById(id)));
    }

    @PutMapping("/updatesalario")
    public ResponseEntity updateSalario(@Param("id") Long id, @Param("salario") BigDecimal salario) {
        usuarioService.updateSalario(id, salario);
        return ResponseEntity.ok(Usuario.toUsuarioVo(usuarioService.findById(id)));
    }


    @DeleteMapping("/delete")
    public ResponseEntity deleteUsuarioBy(@Param("id") Long id) {
        usuarioService.deleteById(id);
        return ResponseEntity.ok(null);
    }
}
