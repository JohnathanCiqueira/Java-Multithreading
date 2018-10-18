<h1>Java Multithreading</h1>

<h2>Threads</h2>

<p>Os encadeamentos Java são objetos como qualquer outro objeto Java. Threads são instâncias de classes java.lang. Thread ou instâncias 
de subclasses dessa classe. Além de serem objetos, os encadeamentos Java também podem executar código.</p>

<h2>Synchronization</h2>

<p>Quando iniciamos dois ou mais encadeamentos dentro de um programa, pode haver uma situação em que vários encadeamentos tentam acessar 
o mesmo recurso e, finalmente, podem produzir um resultado imprevisto devido a problemas de simultaneidade. Por exemplo, se vários segmentos 
tentarem gravar dentro de um mesmo arquivo, eles poderão corromper os dados porque um dos threads pode substituir dados ou enquanto um thread 
está abrindo o mesmo arquivo ao mesmo tempo em que outro thread pode estar fechando o mesmo arquivo.</p>

<p>Portanto, é necessário sincronizar a ação de vários encadeamentos e garantir que apenas um encadeamento possa acessar o recurso em um 
determinado ponto no tempo. Isso é implementado usando um conceito chamado monitores . Cada objeto em Java está associado a um monitor, 
que um encadeamento pode bloquear ou desbloquear. Apenas um thread de cada vez pode conter um bloqueio em um monitor.</p>

<h2>Synchronized Keywork</h2>

<p>Blocos sincronizados em Java são marcados com a synchronized palavra - chave. Um bloco sincronizado em Java é sincronizado 
em algum objeto. Todos os blocos sincronizados sincronizados no mesmo objeto podem ter apenas um thread executando dentro deles 
ao mesmo tempo. Todos os outros threads que tentam entrar no bloco sincronizado são bloqueados até que o thread dentro do bloco 
sincronizado saia do bloco.</p>

<p>A synchronizedpalavra-chave pode ser usada para marcar quatro tipos diferentes de blocos:</p>

<li>Métodos de instância</li>
<li>Métodos estáticos</li>
<li>Blocos de código dentro dos métodos da instância</li>
<li>Blocos de código dentro de métodos estáticos</li>

<p>Esses blocos são sincronizados em objetos diferentes. Qual tipo de bloco sincronizado você precisa depende da situação concreta.</p>

<h2>Thread Pool</h2>

<p>É um conjunto de threads pré-instanciadas prontas para uso. Elas não costumam ser liberadas, e ficam lá disponíveis para reciclagem. 
Na verdade o processo de criação e destruição é um pouco mais complicado que isto e dependente de implementação, mas o básico é isto. 
Algumas serão destruídas se tiver excesso.</p>

<p>Criar uma thread custa um pouco caro. Manter controle de todas ativas não é uma tarefa tão simples. Ter uma objeto que gerencie isto 
ajuda muito já que foi feito porque quem entende bem do assunto e com ela viabiliza usar threads de execução mais curta, já que o custo 
é minimizado por não ter que ficar criando e destruindo várias threads.</p>

<p>Em alguns casos é possível criar uma fila de execução.</p>

<h3>Exemplo específico</h3>
<p>De fato o newFixedThreadPool cria um pool com threads com 10 threads e não passará disto, se passar, entra em fila.</p>

<p>A forma como está usando não é um problema, mas há pouco ou nenhum ganho em relação ao uso normal de threads. 
Talvez fique mais organizado, mas o desempenho não será melhorado.</p>

<h3>Conclusão</h3>
<p>O padrão de projeto de pool é muito usado em vários casos avançados de programação para reaproveitar objetos que podem ser reciclados.</p>

<p>mais informações https://en.wikipedia.org/wiki/Thread_pool</p>

<h2>Countdown Latches</h2>

<p>CountDownLatchfunciona no princípio de trava, o fio principal vai esperar até que o portão esteja aberto. Um thread aguarda por n threads, 
especificado durante a criação do CountDownLatch.</p>

<p>Qualquer thread, geralmente o thread principal do aplicativo, que chama CountDownLatch.await()esperará até que a contagem chegue a zero 
ou seja interrompida por outro thread. Todos os outros segmentos são obrigados a fazer uma contagem regressiva, chamando CountDownLatch.countDown()
assim que estiverem concluídos ou prontos.</p>

<p>Assim que a contagem atingir zero, o encadeamento de espera continua. Uma das desvantagens / vantagens CountDownLatchdisso é que não é 
reutilizável: uma vez que a contagem chega a zero você não pode usar CountDownLatchmais.</p>

<h2>Producer and Consumer</h2>

<p>O padrão Producer Consumer Design é um padrão clássico de simultaneidade ou segmentação que reduz o acoplamento entre
Produtor e Consumidor, separando a identificação do trabalho com a execução do trabalho. No padrão de design do consumidor do produtor, 
uma fila compartilhada é usada para controlar o fluxo e essa separação permite codificar o produtor e o consumidor separadamente. 
Também aborda a questão do tempo diferente necessário para produzir item ou item consumidor. Usando o padrão de consumo do produtor, 
tanto o Producer quanto o Consumer Thread podem trabalhar com velocidade diferente.</p>

<h3>Vantagens Producer-Consumer</h3>

<li>Desenvolvimento simples do Producer Consumer Pattern. você pode codificar o Produtor e o Consumidor de forma independente e, 
ao mesmo tempo, eles só precisam conhecer o objeto compartilhado.</li>

<li>O produtor não precisa saber quem é consumidor ou quantos consumidores estão lá. O mesmo acontece com o consumidor.</li>

<li>Produtor e Consumidor podem trabalhar com velocidade diferente. Não há risco de consumir item semi-cozido.
De fato, monitorando a velocidade do consumidor, pode-se introduzir mais consumidor para melhor utilização.</li>

<li>Separar a funcionalidade de produtor e consumidor resulta em código mais limpo, legível e gerenciável.</li>

<h3>Desvantagens Producer-Consumer</h3>

<p>O Problema Produtor-Consumidor é também uma pergunta popular sobre entrevista em java onde o entrevistador pede para implementar o padrão 
de design do consumidor do produtor para que o Produtor espere se a Fila ou o balde estiver cheio e o Consumidor deve esperar se a fila ou
balde está vazio. Este problema pode ser implementado ou resolvido de diferentes maneiras em Java, a maneira clássica é usar wait e notificar 
o método para se comunicar entre o Producer e o Consumer thread e bloquear cada um deles em condições individuais como full queue e empty queue. 
Com a introdução da Estrutura de Dados do BlockingQueue no Java 5 Agora é muito mais simples porque o BlockingQueue fornece esse controle 
implicitamente introduzindo os métodos de bloqueio put () e take (). Agora você não precisa usar espera e notificar para se comunicar entre 
Produtor e Consumidor. O método blockingQueue put () será bloqueado se a Fila estiver cheia no caso de Fila Limitada e o take () será bloqueado 
se a Fila estiver vazia. </p>

<h2>Wait - Notify - NotifyAll</h2>

<p>A classe Object em java contém três métodos finais que permitem que os threads se comuniquem sobre o status de bloqueio de um recurso. 
Esses métodos são wait () , notify () e notifyAll () . Então, hoje vamos olhar para esperar, notificar e notifyAll no programa java.</p>

<h3>Wait</h3>

<p>Os métodos de espera de objeto têm três variações, uma que aguarda indefinidamente que qualquer outro segmento chame o método notify ou notifyAll 
no objeto para ativar o thread atual. Outras duas variações colocam o segmento atual em espera por um período de tempo específico antes de serem 
ativadas.</p>

<h3>Notify</h3>

<p>O método notify ativa apenas um thread em espera no objeto e esse thread inicia a execução. Portanto, se houver vários encadeamentos 
aguardando um objeto, esse método despertará apenas um deles. A escolha do encadeamento a ser ativado depende da implementação do sistema 
operacional do gerenciamento de encadeamentos.</p>

<h2>DeadLock</h2>

<p>Deadlock descreve uma situação em que dois ou mais threads são bloqueados para sempre, aguardando um pelo outro. O deadlock ocorre quando 
vários threads precisam dos mesmos bloqueios, mas os obtêm em ordem diferente. Um programa multithread Java pode sofrer da condição de deadlock 
porque a palavra - chave synchronized faz com que o thread em execução seja bloqueado enquanto aguarda o bloqueio, ou monitor, associado ao objeto 
especificado.</p>

<h2>Semaphores</h2>

<p>Um Semaphore é uma construção de sincronização de encadeamento que pode ser usada para enviar sinais entre encadeamentos para evitar a perda 
de sinais ou para proteger uma seção crítica como você faria com uma trava . A partir Java 5 vem com implementações de semáforo no 
java.util.concurrent.Semaphore pacote para que você não tenha que implementar seus próprios semáforos.</p>

<h2>Callable and Future</h2>

<h3>Callable</h3>

<p>ava Callable interface use Generic para definir o tipo de retorno de Object. Executors class fornecem métodos úteis para executar Java Callable 
em um pool de threads. Como as tarefas que podem ser chamadas são executadas em paralelo, precisamos aguardar o objeto retornado.</p>

<h3>Future</h3>

<p>As tarefas Java Callable retornam o objeto java.util.concurrent.Future . Usando o objeto Java Future , podemos descobrir o status da tarefa 
Callable e obter o objeto retornado. Ele fornece o método get () que pode esperar que o Callable termine e retorne o resultado.</p>

<p>Java Future fornece o método cancel () para cancelar a tarefa Callable associada. Existe uma versão sobrecarregada do método get () onde podemos 
especificar o tempo de espera pelo resultado, é útil evitar que o thread atual seja bloqueado por mais tempo. Existem métodos isDone () e 
isCancelled () para descobrir o status atual da tarefa Callable associada.</p>

<h2>Interrupting Threads</h2>

<p>Uma interrupção é uma indicação para um segmento que deve parar o que está fazendo e fazer outra coisa. Cabe ao programador decidir exatamente 
como um thread responde a uma interrupção, mas é muito comum que o thread termine. Este é o uso enfatizado nesta lição.</p>

<p>Um thread envia uma interrupção invocando interrupto Thread objeto para o segmento a ser interrompido. Para que o mecanismo de interrupção funcione 
corretamente, o thread interrompido deve suportar sua própria interrupção.</p>

<h2>Multithreading</h2>

<p>Multithreading é um recurso Java que permite a execução simultânea de duas ou mais partes de um programa para utilização máxima da CPU. 
Cada parte desse programa é chamada de thread. Assim, os threads são processos leves dentro de um processo. </p>