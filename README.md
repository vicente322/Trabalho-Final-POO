# Trabalho-Final-POO

Jogo de Pokemon TCG (Simplificado)

Classes:
- Card (abstrata); *No momento essa classe nao esta abstrata*
- Energy (sub-classe de Card);
- Pokemon (sub-classe de Card);
- Trainer (sub-classe de Card);
- Tipos de Pokemon (varias classes, sub-classes de Pokemon);
- Tipos de Trainer (Talvez? sub-classes de Trainer);

Cartas com proporcao de 4 de altura pra 3 de largura;

2 decks pre prontos (por hora pelo menos);
30 cartas em cada deck;
Pokemons com vida;
Fim do jogo quando mata 6 Pokemon ou se o oponente nao
puder botar outro Pokemon;

*PONTOS IMPORTANTES PARA O TRABALHO*
- "A cada jogada um jogador pode colocar ou retirar uma carta da mesa ou acionar algum 
efeito da carta". Isso quer dizer so uma acao por turno?

- Computador deve anunciar de quem e a vez e pedir confirmacao antes de mostrar tela

- Computador deve poder detectar final do jogo

- Interface deve permitir:
      - Reiniciar o jogo
      - Colocar os nomes dos jogadores (FEITO)
      - Verificar "vidas"
      - Embaralhar e sacar cartas