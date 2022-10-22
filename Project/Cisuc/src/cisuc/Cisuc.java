/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cisuc;

import java.io.*;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author faria
 */
public class Cisuc {

    private ArrayList<ResearchGroup> investigators;
    private ArrayList<Publication> publications;

    /**
     * construtor da classe Cisuc
     */
    public Cisuc() {
        investigators = new ArrayList<>();
        publications = new ArrayList<>();
    }

    public static void main(String[] args) {
        //inicialização de uma variavel do tipo Cisuc de modo a manipular os dados
        Cisuc program = new Cisuc();

        //inicializar os arrays com a informação contida nos ficheiros
        program.getInfoObject();

        //comeca o processo atraves do metodo process, isto e mostra o menu de opcoes disponiveis para este programa
        program.process();
    }

    /**
     * metodo que permite ao utilizador interagir com os dados,ciclo infinito
     * para o utilizador poder executar qualquer das funcionalidades disponiveis
     */
    private void process() {
        System.out.println("-------Start--------");

        //menu de opcoes
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        do {// Menu

            System.out.println("");
            System.out.println("-------------Gestor de publicacoes CISUC-----------");

            //apresentar ao utilizador as diferentes funcionalidades do programa
            System.out.println("1 - Apresentar os indicadores gerais do CISUC");
            System.out.println("2 - Listar as publicações de um grupo de investigação, dos últimos 5 anos, organizadas por ano, por tipo de publicação e por fator de impacto");
            System.out.println("3 - Listar os membros de um grupo de investigação agrupados por categoria");
            System.out.println("4 - Listar as publicações de um investigador agrupadas por ano, tipo de publicação e fator de impacto");
            System.out.println("5 - Listar todos os grupos de investigação,apresentando as caracteristicas de cada grupo");
            System.out.println("0 - Sair");

            System.out.println("");

            //atribuicao do valor dado ao int choice
            try {
                choice = sc.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println("a escolha tem de ser um inteiro");

                //caso o valor inserido nao seja um int atribuit o valor 6 a variavel choice de modo a ir para a opcao default e impedir a parragem do programa 
                choice = 6;
            }

            switch (choice) {
                case 1:
                    //utilizando o metodo indCisuc apresentar a informacao sobre os dados nos arrays
                    this.indCisuc();
                    break;
                case 2:
                    //utilizando o metodo printGroupPublications listar as publicações de um grupo de investigação, dos últimos 5 anos, organizadas por ano, por tipo de publicação e por fator de impacto
                    this.printGroupPublications();
                    break;
                case 3:
                    //utilizando o metodo printmembros listar os membros de um grupo de investigação agrupados por categoria
                    this.printmembros();
                    break;
                case 4:
                    //utilizando o metodo printInvestigatorPublications listar as publicações de um investigador agrupadas por ano, tipo de publicação e fator de impacto
                    this.printInvestigatorPublications();
                    break;
                case 5:
                    //utilizando o metodo listResearchGroups listar todos os grupos de investigação,apresentando as caracteristicas de cada grupo
                    this.listResearchGroups();
                    break;
                case 0:
                    //guarda as informacoes em ficheiros de objectos
                    this.updateFiles();

                    System.out.println("-------End--------");
                    System.exit(0);
                default:
                    //caso o numero nao seja nenhum dos valores esperados avisar o utilizador 
                    System.out.println("invalid number");
                    break;
            }

        } while (true);

    }

    /**
     * le e atribui as informacoes dos ficheiros, comecando por tentar atraves
     * dos de objectos caso estes nao existam recorre aos de texto
     */
    private void getInfoObject() {

        File f = new File("gruposInvestigacao.obj");

        //if para confimar se o ficheiro existe caso nao existe recorre aos ficheiros de texto
        if (f.exists() && f.isFile()) {
            //experimentar ler os data do ficheiro caso ocorram erros avisar o utilizaador no erro da execucao
            try {
                //inicializacao das variaveis para ler no ficheiro f
                FileInputStream fis = new FileInputStream(f);
                ObjectInputStream ois = new ObjectInputStream(fis);

                //percorer o ficheiro f e adicionar os abjetos ao array investigators
                investigators = (ArrayList<ResearchGroup>) ois.readObject();

                //fecha o ficheiro
                ois.close();

            } catch (FileNotFoundException ex) {
                System.out.println("Erro a abrir ficheiro,tentar carregar os dados a partir dos ficheiros de texto.");

                //recorrer ao ficheiro de texto para obter as informacoes 
                getReserachGroupText();
            } catch (IOException ex) {
                System.out.println("Erro a ler ficheiro,tentar carregar os dados a partir dos ficheiros de texto.");

                //recorrer ao ficheiro de texto para obter as informacoes 
                getReserachGroupText();
            } catch (ClassNotFoundException ex) {
                System.out.println("Erro a converter objeto.");
            }
        } //caso o ficheiro de objectos nao exista avisar o utilizador e recorrer ao ficheiro de texto para obter as informacoes  
        else {
            //avisa o utilizador 
            System.out.println("Ficheiro objecto não existe,carrega os dados a partir dos ficheiros de texto");
            getReserachGroupText();
        }

        f = new File("publicacoes.obj");
        if (f.exists() && f.isFile()) {
            //experimentar ler os data do ficheiro caso ocorram erros avisar o utilizaador no erro da execucao
            try {
                //inicializacao das variaveis para ler no ficheiro f
                FileInputStream fis = new FileInputStream(f);
                ObjectInputStream ois = new ObjectInputStream(fis);

                //percorer o ficheiro f e adicionar os abjetos ao array publications
                publications = (ArrayList<Publication>) ois.readObject();

                //fecha o ficheiro
                ois.close();

            } catch (FileNotFoundException ex) {
                System.out.println("Erro a abrir ficheiro,tentar carregar os dados a partir dos ficheiros de texto.");
                //recorrer ao ficheiro de texto para obter as informacoes 
                getPublicationsText();
            } catch (IOException ex) {
                System.out.println("Erro a ler ficheiro,tentar carregar os dados a partir dos ficheiros de texto.");
                //recorrer ao ficheiro de texto para obter as informacoes 
                getPublicationsText();
            } catch (ClassNotFoundException ex) {
                System.out.println("Erro a converter objeto.");
            }
        } //caso o ficheiro de objectos nao exista avisar o utilizador e recorrer ao ficheiro de texto para obter as informacoes  
        else {
            //avisa o utilizador 
            System.out.println("Ficheiro objecto não existe,carrega os dados a partir dos ficheiros de texto");

            //recorrer ao ficheiro de texto para obter as informacoes 
            getPublicationsText();
        }
    }

    /**
     * le as informacoes relativas aos grupos de investigacao dos ficheiros de
     * texto
     */
    private void getReserachGroupText() {
        File f = new File("gruposInvestigacao.txt");

        //verifica se o ficheiro existe e avisa o utilizador de eventuais erros
        if (f.exists() && f.isFile()) {

            //experimentar ler os data do ficheiro caso ocorram erros avisar o utilizaador no erro da execucao
            try {

                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);

                String line;

                //varivel que ira referenciar o ultimo grupo de investigacao lido
                ResearchGroup group = new ResearchGroup();

                //varivel que ira referenciar o ultimo membro efetivo lido
                EffectiveMember advisor = new EffectiveMember();

                while ((line = br.readLine()) != null) {
                    //dividir a linha pelas virgulas de modo a que cada valor do array dados representa um atributo para os investigadores
                    String[] dados = line.split(",");

                    //switch que percorre todas as opcoes de modo a saber se se pretende adicionar um novo grupo de investigação out se se pretende adicionar um membro efetivo ou estudante
                    switch (dados[0]) {

                        //caso membro efetivo
                        case "effective":

                            //verifica se um grupo de investigacao ja foi inicializado caso nao tenha sido avisa o utilizador e termina a execucao de programa
                            if (group.getName().equals("")) {
                                System.out.println("Dados mal introduzidos,no ficheiro o grupo de investigação tem de estar primeiro e so depois os respetivos membros");
                                System.exit(0);
                            }
                            //verifica se os dados estao bem codificados isto e se na linha estao todos os dados necessarios
                            if (dados.length != 5) {
                                System.out.println("Dados mal introduzidos,os membros efetivos tem de estar escritos do seguinte modo:");
                                System.out.println("effective,<nome>,<email>,<numero de gabinete>,<numero de telefone>");
                                System.exit(0);
                            }

                            //inicializacao e atribuição do membro effetivo
                            advisor = new EffectiveMember(dados[1], dados[2], group, Integer.parseInt(dados[3]), Integer.parseInt(dados[4]));
                            group.addMembro(advisor);

                            break;

                        //caso seja estudante
                        case "student":
                            //verifica se um grupo de investigacao ja foi inicializado caso nao tenha sido avisa o utilizador e termina a execucao d programa
                            if (group.getName().equals("")) {
                                System.out.println("Dados mal introduzidos,no ficheiro o grupo de investigação tem de estar primeiro e so depois os respetivos membros");
                            }

                            //verifica se os dados estao bem codificados isto e se na linha estao todos os dados necessarios
                            if (dados.length != 5) {
                                System.out.println("Dados mal introduzidos,os estudantes tem de estar escritos do seguinte modo:");
                                System.out.println("student,<nome>,<email>,<título da tese>, <data prevista de conclusão>.");
                                System.exit(0);
                            }

                            //verifica se um advisor ja foi inicializado caso nao tenha sido avisa o utilizador e termina a execucao d programa
                            if (advisor.getName().equals("")) {
                                System.out.println("Dados mal introduzidos, certifique-se que o orientador para este estudante e o membro efectivo anterior.");
                                System.exit(0);
                            }
                            group.addMembro(new Student(dados[1], dados[2], group, dados[3], dados[4], advisor));
                            break;
                        case "group":
                            //verifica se os dados estao bem codificados isto e se na linha estao todos os dados necessarios
                            if (dados.length != 7) {
                                System.out.println("Dados mal introduzidos,os grupos de investigação tem de estar escritos do seguinte modo:");
                                System.out.println("group,<nome>,<sigla>,<nome do investigador responsavel>,<email do investigador responsavel>,<numero de gabinete do investigador responsavel>,<numero de telefone do investigador responsavel>.");
                                System.exit(0);
                            }

                            //inicializacao do grupo de investigacao
                            group = new ResearchGroup(dados[1], dados[2]);

                            //inicializacao do advisor
                            advisor = new EffectiveMember(dados[3], dados[4], group, Integer.parseInt(dados[5]), Integer.parseInt(dados[6]));

                            //adicao do advisor ao grupo de investigacao
                            group.setResponsibleResearcher(advisor);
                            group.addMembro(advisor);

                            //adicao do group ao array de grupos de investigacao,investigators
                            investigators.add(group);
                            break;
                        case "":
                            break;
                        default:
                            System.out.println("Dados incorretamente escritos");
                            System.exit(0);
                    }
                }
                br.close();
            } catch (FileNotFoundException ex) {
                System.out.println("Erro a abrir ficheiro de texto.");
            } catch (IOException ex) {
                System.out.println("Erro a ler ficheiro de texto.");
            } catch (java.lang.NumberFormatException ex) {
                System.out.println("Erro ao passar o string para inteiro");
                System.exit(0);
            }
        } else {
            System.out.println("Ficheiro não existe.");
        }
    }

    /**
     * le as informacoes relativas as publicacoes dos ficheiros de texto
     */
    private void getPublicationsText() {
        File f = new File("publicacoes.txt");

        //verifica se o ficheiro existe e avisa o utilizador de eventuais erros
        if (f.exists() && f.isFile()) {

            //experimentar ler os data do ficheiro caso ocorram erros avisar o utilizaador no erro da execucao
            try {
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);

                String line;

                //varivel que ira referenciar o ultimo membro efetivo lido
                while ((line = br.readLine()) != null) {

                    //dividir a linha pelas virgulas de modo a que cada valor do array dados representa um atributo para as publicacoes
                    String[] data = line.split(",");

                    //switch que percorre todas as opcoes de modo a saber que tipo de publicacao se pretende adicionar 
                    switch (data[0]) {
                        case "book":
                            Publication p = new Book(data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]), br.readLine(), data[4], data[5]);

                            //le a nova linha que corresponde as keywords e adiciona as ao array respetivo
                            line = br.readLine();
                            data = line.split(",");
                            for (String s : data) {
                                p.addKeyWords(s);
                            }

                            //le a nova linha que corresponda aos autores e adiciona ao array respetivo caso um dos nvestigadores nao existir informa o utilizador
                            line = br.readLine();
                            data = line.split(",");
                            boolean checkInvestigator = false;
                            for (String s : data) {
                                for (ResearchGroup g : investigators) {
                                    for (Investigator i : g.getMembers()) {
                                        if (i.getEmail().equals(s)) {
                                            checkInvestigator = true;
                                            p.addAuthors(i);
                                            break;
                                        }
                                    }
                                    if (checkInvestigator) {
                                        break;
                                    }
                                }
                                if (!checkInvestigator) {
                                    System.out.println("Nenhum investigador encontrado com o email " + s);
                                }
                                checkInvestigator = false;
                            }

                            //adicionas ao array das publicacoes
                            publications.add(p);
                            break;
                        case "book chapters":
                            p = new BookChapters(data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]), br.readLine(), data[4], data[5], data[6], Integer.parseInt(data[7]), Integer.parseInt(data[8]));

                            //le a nova linha que corresponde as keywords e adiciona as ao array respetivo
                            line = br.readLine();
                            data = line.split(",");
                            for (String s : data) {
                                p.addKeyWords(s);
                            }

                            //le a nova linha que corresponda aos autores e adiciona ao array respetivo caso um dos nvestigadores nao existir informa o utilizador
                            line = br.readLine();
                            data = line.split(",");
                            checkInvestigator = false;
                            for (String s : data) {
                                for (ResearchGroup g : investigators) {
                                    for (Investigator i : g.getMembers()) {
                                        if (i.getEmail().equals(s)) {
                                            checkInvestigator = true;
                                            p.addAuthors(i);
                                            break;
                                        }
                                    }
                                    if (checkInvestigator) {
                                        break;
                                    }
                                }
                                if (!checkInvestigator) {
                                    System.out.println("Nenhum investigador encontrado com o email " + s);
                                }
                                checkInvestigator = false;
                            }

                            //adicionas ao array das publicacoes
                            publications.add(p);
                            break;
                        case "conference article book":
                            p = new ConferenceArticleBook(data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]), br.readLine(), data[4], data[5], data[6], Integer.parseInt(data[7]));

                            //le a nova linha que corresponde as keywords e adiciona as ao array respetivo
                            line = br.readLine();
                            data = line.split(",");
                            for (String s : data) {
                                p.addKeyWords(s);
                            }

                            //le a nova linha que corresponda aos autores e adiciona ao array respetivo caso um dos nvestigadores nao existir informa o utilizador
                            line = br.readLine();
                            data = line.split(",");
                            checkInvestigator = false;
                            for (String s : data) {
                                for (ResearchGroup g : investigators) {
                                    for (Investigator i : g.getMembers()) {
                                        if (i.getEmail().equals(s)) {
                                            checkInvestigator = true;
                                            p.addAuthors(i);
                                            break;
                                        }
                                    }
                                    if (checkInvestigator) {
                                        break;
                                    }
                                }
                                if (!checkInvestigator) {
                                    System.out.println("Nenhum investigador encontrado com o email " + s);
                                }
                                checkInvestigator = false;
                            }

                            //adicionas ao array das publicacoes
                            publications.add(p);
                            break;
                        case "conference article":
                            p = new ConferenceArticle(data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]), br.readLine(), data[4], data[5], data[6]);

                            //le a nova linha que corresponde as keywords e adiciona as ao array respetivo
                            line = br.readLine();
                            data = line.split(",");
                            for (String s : data) {
                                p.addKeyWords(s);
                            }

                            //le a nova linha que corresponda aos autores e adiciona ao array respetivo caso um dos nvestigadores nao existir informa o utilizador
                            line = br.readLine();
                            data = line.split(",");
                            checkInvestigator = false;
                            for (String s : data) {
                                for (ResearchGroup g : investigators) {
                                    for (Investigator i : g.getMembers()) {
                                        if (i.getEmail().equals(s)) {
                                            checkInvestigator = true;
                                            p.addAuthors(i);
                                            break;
                                        }
                                    }
                                    if (checkInvestigator) {
                                        break;
                                    }
                                }
                                if (!checkInvestigator) {
                                    System.out.println("Nenhum investigador encontrado com o email " + s);
                                }
                                checkInvestigator = false;
                            }

                            //adicionas ao array das publicacoes
                            publications.add(p);
                            break;
                        case "magazine article":
                            p = new MagazineArticle(data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]), br.readLine(), data[4], data[5], Integer.parseInt(data[6]));

                            //le a nova linha que corresponde as keywords e adiciona as ao array respetivo
                            line = br.readLine();
                            data = line.split(",");
                            for (String s : data) {
                                p.addKeyWords(s);
                            }

                            //le a nova linha que corresponda aos autores e adiciona ao array respetivo caso um dos nvestigadores nao existir informa o utilizador
                            line = br.readLine();
                            data = line.split(",");
                            checkInvestigator = false;
                            for (String s : data) {
                                for (ResearchGroup g : investigators) {
                                    for (Investigator i : g.getMembers()) {
                                        if (i.getEmail().equals(s)) {
                                            checkInvestigator = true;
                                            p.addAuthors(i);
                                            break;
                                        }
                                    }
                                    if (checkInvestigator) {
                                        break;
                                    }
                                }
                                if (!checkInvestigator) {
                                    System.out.println("Nenhum investigador encontrado com o email " + s);
                                }
                                checkInvestigator = false;
                            }

                            //adicionas ao array das publicacoes
                            publications.add(p);
                            break;
                        case "":
                            break;
                        default:
                            System.out.println("Dados incorretamente escritos");
                            System.exit(0);
                    }
                }
                br.close();
            } catch (FileNotFoundException ex) {
                System.out.println("Erro a abrir ficheiro de texto.");
            } catch (IOException ex) {
                System.out.println("Erro a ler ficheiro de texto.");
            } catch (java.lang.NumberFormatException ex) {
                System.out.println("Erro ao passar o string para inteiro");
                System.exit(0);
            }
        } else {
            System.out.println("Ficheiro não existe.");
        }
    }

    /**
     * *
     * metodo que permite a impressão de todos os indicadores de cisuc
     */
    private void indCisuc() {
        int numEffective = 0;
        int numStudents = 0;

        //ciclo que conta o numero de investigadores de cada tipo
        for (ResearchGroup g : investigators) {
            for (Investigator i : g.getMembers()) {
                if (i.getType().equals("effective")) {
                    numEffective += 1;
                } else {
                    numStudents += 1;
                }
            }
        }

        //print dos valores calculados
        System.out.println("Total de investigadores= " + (numEffective + numStudents));
        System.out.println("Total de membros efetivos= " + numEffective);
        System.out.println("Total de Estudantes= " + numStudents);

        //inicializacao de toas as variaveis 
        int totalPublications = 0;
        int numMagazineArticles = 0;
        int numBooks = 0;
        int numBookCharapters = 0;
        int numConferenceArticle = 0;
        int numConferenceArticleBooks = 0;

        //receber o ano atual 
        Calendar cal = GregorianCalendar.getInstance();
        int year = cal.get(Calendar.YEAR);

        //ciclo que conta o numero de publicaoes de cada tipo 
        for (Publication p : publications) {
            switch (p.getType()) {
                case "magazine article":
                    numMagazineArticles += 1;
                    break;
                case "book":
                    numBooks += 1;
                    break;
                case "book chapters":
                    numBookCharapters += 1;
                    numBooks += 1;
                    break;
                case "conference article":
                    numConferenceArticle += 1;
                    break;
                case "conference article book":
                    numConferenceArticleBooks += 1;
                    numBooks += 1;
                default:
                    break;
            }
            if (year - p.getPublicationYear() <= 5) {
                totalPublications += 1;
            }
        }

        System.out.println("Numero de publicacoes dos ultimos 5 anos= " + totalPublications);
        System.out.println("Numero de artigos de revista= " + numMagazineArticles);
        System.out.println("Numero de livros= " + numBooks);
        System.out.println("Numero de capítulos de livro= " + numBookCharapters);
        System.out.println("Numero de livro de artigos de conferência= " + numConferenceArticleBooks);
        System.out.println("Numero de artigos de conferencia= " + numConferenceArticle);
    }

    /**
     * Listar as publicações de um grupo de investigação, dos últimos 5 anos,
     * organizadas por ano, por tipo de publicação
     */
    private void printGroupPublications() {
        //pede ao utilizador a sigla do grupo desejado
        Scanner sc = new Scanner(System.in);
        System.out.print("Sigla do grupo:");
        String s = sc.nextLine();

        //verifica se o grupo existe
        boolean GroupExists = false;
        for (ResearchGroup g : investigators) {
            if (g.getAcronym().equals(s)) {
                GroupExists = true;
            }
        }

        if (GroupExists) {
            System.out.println("");
            System.out.println("--------Publicacoes do grupo " + s + "------------");
            System.out.println("");

            //iniicializacao do array para as publicacoes com menus de 5 anos
            ArrayList<Publication> a = new ArrayList<>();

            //obter o ano atual
            Calendar cal = GregorianCalendar.getInstance();
            int currentYear = cal.get(Calendar.YEAR);

            //percorrer todas as publicacoes e adicionar a ao array a toas as com menus de 5 anos
            for (Publication p : publications) {
                for (Investigator i : p.getAuthors()) {
                    if (i.getGroup().getAcronym().equals(s)) {
                        if (currentYear - p.getPublicationYear() <= 5) {
                            a.add(p);
                            break;
                        }
                    }
                }
            }

            //inicializacao de variaveis que iram representar a possicao atual 
            int year = 0;
            String type = "";
            String impactFactor = "";

            //utilizando o collections.sort organizar o array pela ordem desejada
            Collections.sort(a);

            //ciclo que percorre todas as publicacoes em a
            for (Publication p : a) {
                //sempre que o ano mudar imprimir o novo ano e reinicializar as variaveis necessarias
                if (p.getPublicationYear() != year) {
                    year = p.getPublicationYear();
                    type = "";
                    impactFactor = "";
                    System.out.println("-----" + year + "------");
                }

                //sempre que o tipo mudas imprimir o novo tipo i reinicializar as variaveis necessariass
                if (!p.getType().equals(type)) {
                    type = p.getType();
                    impactFactor = "";
                    System.out.println(type + ":");
                }
                //sempre que o fator de impactom mudar imprimir o novo fator de impacto
                if (!p.impactFactor().equals(impactFactor)) {
                    impactFactor = p.impactFactor();
                    System.out.println(impactFactor + ":");
                }
                //imprimir a publicacao
                System.out.println(p);
            }
        } else {
            System.out.println("Grupo nao existe");
        }

    }

    /**
     * imprimir as publicaoes de um investigador
     */
    private void printInvestigatorPublications() {
        //pedir ao utilizador o emal do investigador pretendido 
        Scanner sc = new Scanner(System.in);
        System.out.print("email do investigador:");
        String s = sc.nextLine();

        //inicializacao de um array para todas as publicacoes do investigador com o email s
        ArrayList<Publication> a = new ArrayList<>();

        //verificar se existe um investigador com o email dado
        boolean invesExistes = false;
        for (ResearchGroup g : investigators) {
            for (Investigator i : g.getMembers()) {
                if (i.getEmail().equals(s)) {
                    invesExistes = true;
                }
            }
        }
        if (invesExistes) {
            //ciclo que passa por todas as publicacoes e verifica se um dos autores e o investigador dado caso seja adicionar a a
            for (Publication p : publications) {
                for (Investigator i : p.getAuthors()) {
                    if (i.getEmail().equals(s)) {
                        a.add(p);
                        break;
                    }
                }
            }

            //verifica se o investigador ja fez publicacoes
            if (a.isEmpty()) {
                System.out.println("Este investigador ainda nao fez publicacoes");
            } else {
                //se tiver organixar utilizando o collections.sort
                Collections.sort(a);

                int year = 0;
                String type = "";
                String impactFactor = "";
                
                //imprime todas as publicacoes pela ordem desejada
                for (Publication p : a) {
                    //sempre que o ano mudar imprimir o novo ano e reinicializar as variaveis necessarias
                    if (p.getPublicationYear() != year) {
                        year = p.getPublicationYear();
                        type = "";
                        impactFactor = "";
                        System.out.println("-----" + year + "------");
                    }

                    //sempre que o tipo mudas imprimir o novo tipo i reinicializar as variaveis necessariass
                    if (!p.getType().equals(type)) {
                        type = p.getType();
                        impactFactor = "";
                        System.out.println(type + ":");
                    }
                    //sempre que o fator de impactom mudar imprimir o novo fator de impacto
                    if (!p.impactFactor().equals(impactFactor)) {
                        impactFactor = p.impactFactor();
                        System.out.println(impactFactor + ":");
                    }
                    //imprimir a publicacao
                    System.out.println(p);
                }
            }
        } else {
            System.out.println("Investigador nao encontrado");
        }
    }

    /**
     * imprimir os membros agrupados pr categorias
     */
    private void printmembros() {
        //pede ao utilizador a sigla do grupo do qual se pretende imprimir os membros
        Scanner sc = new Scanner(System.in);
        System.out.print("Sigla do grupo:");
        String s = sc.nextLine();

        boolean GroupExists = false;
        for (ResearchGroup g : investigators) {
            //se o grupo existir atualizar a variavel GroupExists e imprime os membros
            if (g.getAcronym().equals(s)) {
                GroupExists = true;
                
                //utilizando o collections.sort agrupar os grupos dos diversos tipos
                Collections.sort(g.getMembers());
                
                //string para mostrar o tipo atual
                String a = "";
                
                //ciclo que percorre os membros
                for (Investigator i : g.getMembers()) {
                    //assim que mudar de tipo imprimir o novo tipo e atualizar a variavel a
                    if (!a.equals(i.getType())) {
                        System.out.println();
                        System.out.println("--------" + i.getType() + "---------");
                        a = i.getType();
                    }
                    
                    //imprime o investigador
                    System.out.println(i);
                }
                break;
            }
        }
        if (!GroupExists) {
            System.out.println("Grupo nao existe");
        }
    }

    /**
     * imprimir todas as informaçoes relevantes sobre os grupos
     */
    private void listResearchGroups() {
        //ciclo que percorre todos so sgrupos de investigacao
        for (ResearchGroup g : investigators) {
            System.out.println("");
            System.out.println("");
            System.out.println(g.getName() + ", " + g.getAcronym() + ":");
            
            //utilizar o .size() para obter o total de membros
            System.out.println("Total de investigadores= " + g.getMembers().size());

            //contadores do numero de membros
            int numEffective = 0;
            int numStudents = 0;
            for (Investigator i : g.getMembers()) {
                if (i.getType().equals("effective")) {
                    numEffective += 1;
                } else {
                    numStudents += 1;
                }
            }
            
            System.out.println("Total de membros efetivos= " + numEffective);
            System.out.println("Total de Estudantes= " + numStudents);

            //array para as publicacoes co menus de 5 anos feitos por membros deste grupo de investigacao
            ArrayList<Publication> a = new ArrayList<>();

            //receber o ano atual
            Calendar cal = GregorianCalendar.getInstance();
            int year = cal.get(Calendar.YEAR);

            //ciclo que encontra todas as publicacoes do grupo de investigacao com menus d que 5 anos
            for (Publication p : publications) {
                if (year - p.getPublicationYear() <= 5) {
                    for (Investigator i : p.getAuthors()) {
                        if (i.getGroup() == g) {
                            a.add(p);
                            break;
                        }
                    }
                }
            }

            System.out.println("Total de publicacoes= " + a.size());

            //contadores para os diferentes tipos de publicacoes
            int totalPublications = 0;
            int numMagazineArticles = 0;
            int numBooks = 0;
            int numBookCharapters = 0;
            int numConferenceArticle = 0;
            int numConferenceArticleBooks = 0;
            int numPublicationsA = 0;
            int numPublicationsB = 0;
            int numPublicationsC = 0;
            int nPublicacoesAno = 0;

            //organizar as publicacoes de modo a facilitar a contagem
            Collections.sort(a);

            //receber o ano mais velho~
            int ano = a.get(0).getPublicationYear();

            //ciclo que percorre todas as publicacoes contando todas as ocorrencias e informando o utilizador
            for (Publication p : a) {
                if (p.getPublicationYear() != ano) {
                    System.out.println("Foram feitas " + nPublicacoesAno + " no ano " + ano);
                    ano = p.getPublicationYear();
                    nPublicacoesAno = 0;

                } else {
                    nPublicacoesAno += 1;
                }
                switch (p.getType()) {
                    case "magazine articles":
                        numMagazineArticles += 1;
                        break;
                    case "book":
                        numBooks += 1;
                        break;
                    case "book chapters":
                        numBookCharapters += 1;
                        numBooks += 1;
                        break;
                    case "conference article":
                        numConferenceArticle += 1;
                        break;
                    default:
                        numConferenceArticleBooks += 1;
                        numBooks += 1;
                        break;
                }
                switch (p.impactFactor()) {
                    case "A":
                        numPublicationsA += 1;
                        break;
                    case "B":
                        numPublicationsB += 1;
                        break;
                    default:
                        numPublicationsC += 1;
                        break;
                }
            }
            System.out.println("Foram feitas " + nPublicacoesAno + " no ano " + ano);
            System.out.println("Numero de artigos de revista= " + numMagazineArticles);
            System.out.println("Numero de livros= " + numBooks);
            System.out.println("Numero de capítulos de livro= " + numBookCharapters);
            System.out.println("Numero de livro de artigos de conferência= " + numConferenceArticleBooks);
            System.out.println("Numero de artigos de conferencia= " + numConferenceArticle);
            System.out.println("Numero de publicacoes de com nivel de impacto A= " + numPublicationsA);
            System.out.println("Numero de publicacoes de com nivel de impacto B= " + numPublicationsB);
            System.out.println("Numero de publicacoes de com nivel de impacto C= " + numPublicationsC);
        }
    }

    /**
     * guardar as informaçoes em ficheiros objecto
     */
    public void updateFiles() {
        File f = new File("gruposInvestigacao.obj");

        //experimentar ler os dados do ficheiro caso ocorram erros avisar o utilizador no erro da execucao
        try {
            //inicializacao das variaveis para escrever no ficheiro f
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            //escreve o array investigators no ficheiro gruposInvestigacao.obj
            oos.writeObject(investigators);

            //fecha o ficheiro
            oos.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Erro a criar ficheiro.");
        } catch (IOException ex) {
            System.out.println("Erro a escrever para o ficheiro.");
        }

        f = new File("publicacoes.obj");

        //experimentar ler os dados do ficheiro caso ocorram erros avisar o utilizador no erro da execucao
        try {
            //inicializacao das variaveis para escrever no ficheiro f
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            //escreve o array publications no ficheiro publicacoes.obj
            oos.writeObject(publications);

            //fecha o ficheiro
            oos.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Erro a criar ficheiro.");
        } catch (IOException ex) {
            System.out.println("Erro a escrever para o ficheiro.");
        }
    }
}
