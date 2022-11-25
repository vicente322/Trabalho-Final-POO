Fiz apenas 2 baralhos. Estamos apertados por tempo, então achei melhor cortar o numero de afazeres. Também acho que o banco demoraria pra implementar, então to por cortar ele mesmo. Faz que quando recuar a carta só discarta todas as energias e volta pra mão. (Só tem 10 energias por baralho então não pode ficar enrolando)

Os efeitos especiais de cada ataque e carta de treinador são dados por ids. A gente implementa eles quando programar os ataques e as cartas de item em sí.

o arquivo teste.java tem a inicialização de todas as cartas e dos baralhos. Não sabia onde implementaria no programa de exemplo do sor então por enquanto tá aqui.

o ImageFactory.java é igual ao do sor, só que troquei os endereços das imagens para as nossas cartas. Quando for realmente implementar, só copiar o conteudo da pasta Cards para src/main/resources/imagens

Acabei não fazendo classes separadas para cada tipo de pokemon. Acho q não teria muito sentido pra isso, ja que todo pokemon precisa ter. No maximo, talvez poderia fazer uma classe separada pra pokemons que são evoluções. Eu posso modificar aqui se quiserem.

=============================================================================================================================

ID DOS EFEITOS

POKEMON:
1 - Cura 10 de dano deste pokemon (CARTA: BELLSPROUT)
2 - Jogue cara ou coroa. Se coroa, ataque não faz nada (CARTA: EEVEE, SKWOVET, STARLY)
3 - Dano total = dano do ataque + dano que o pokemon do oponente ja tem (CARTA: FARFETCH'D)
4 - Dano total = dano do ataque + 10 para cada pokemon na sua pilha de descarte (CARTA: FLAREON)
5 - Pokemon causa 10 de dano a sí mesmo (CARTA: FLAREON)
6 - Deixa o pokemon do oponente confuso. (CARTA: GLOOM)
7 - Jogue cara ou coroa. Se cara, soma 20 ao dano do ataque (CARTA: HERDIER)
8 - Compre uma carta (CARTA: LILLIPUP)
9 - Se o pokemon do oponente tem uma condição especial, soma 90 ao dano do ataque (CARTA: NINETALES)
10 - Deixa o pokemon do oponente dormindo (CARTA:NINETALES)
11 - Deixa o pokemon do oponente envenenado (CARTA:ODDISH)
12 - Deixa o pokemon do oponente queimado (CARTA:VULPIX)
13 - Deixa o pokemon do oponente queimado e envenenado (CARTA:WEEPINBELL)

14 - Jogue 3 moedas. Ataque causa x de dano para cada cara (CARTA:ALOLAN SANDSHREW, CORVISQUIRE)
15 - Jogue uma moeda. Se cara, soma 40 ao dano do ataque (CARTA:ALOLAN SANDSLASH)
16 - Jogue uma moeda. Se cara, soma 30 ao dano do ataque (CARTA:LAIRON)
17 - Deixa o pokemon do oponente paralizado (CARTA:PRINPLUP)

TREINADORES:
18 - Compre 3 cartas (CARTA:HAU)
19 - Cure 20 de danos do seu pokemon (CARTA:POTION)
20 - Cure todas as condições especiais do seu pokemon (CARTA:FULL HEAL)


