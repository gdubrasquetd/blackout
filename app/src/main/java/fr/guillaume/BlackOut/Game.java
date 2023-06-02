package fr.guillaume.BlackOut;

import android.util.JsonReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Game {
    static private final List<Player> players = new ArrayList<Player>();
    static private final List<Player> girls = new ArrayList<Player>();
    static private final List<Player> boys = new ArrayList<Player>();
    static private final List<String> duelTmp = new ArrayList<String>();
    static private final List<String> duel = new ArrayList<String>();
    static private final List<String> globalTmp = new ArrayList<String>();
    static private final List<String> global = new ArrayList<String>();
    static private final List<String> minijeuTmp = new ArrayList<String>();
    static private final List<String> minijeu = new ArrayList<String>();
    static private final List<String> dilemTmp = new ArrayList<String>();
    static private final List<String> dilem = new ArrayList<String>();
    static private final List<String> roleTmp = new ArrayList<String>();
    static private final List<String> role = new ArrayList<String>();
    static private final List<String> actionsTmp = new ArrayList<String>();
    static private final List<String> actions = new ArrayList<String>();
    static private final List<String> verites = new ArrayList<String>();
    static private final List<String> veritesTmp = new ArrayList<String>();
    static private final List<String> transitionsF = new ArrayList<String>();
    static private final List<String> transitionsFTmp = new ArrayList<String>();
    static private final List<String> transitionsH = new ArrayList<String>();
    static private final List<String> transitionsHTmp = new ArrayList<String>();
    static private final List<Player> passedPlayer = new ArrayList<Player>();
    static private final Player RIP = new Player("Erreur de la nature");
    static private Player lastPlayer = RIP;
    private final int ID;
    private final int round = 0;
    private final Random rand = new Random();
    public boolean duelBool = true;
    public boolean globalBool = true;
    public boolean minijeuBool = true;
    public boolean dilemBool = true;
    public boolean roleBool = true;

    public Game(int ID) {
        this.ID = ID;
    }


    public List<Player> getPlayerList() {
        return players;
    }

    public void addPlayers(Player player) {
        if (!player.getName().toString().isEmpty()) {
            players.add(player);
        }
        if (player.isGenre() == true && !player.getName().toString().isEmpty()) {
            boys.add(player);
        }
        if (!player.isGenre() == true && !player.getName().toString().isEmpty()) {
            girls.add(player);
        }
    }

    public Player getRandomPlayer() {
        List<Player> cp = new ArrayList<Player>(players);

        if (players.size() == passedPlayer.size()) {
            cp.remove(lastPlayer);
            passedPlayer.clear();
        } else {
            for (Player p1 : passedPlayer) {
                cp.remove(p1);
            }
        }
        Player play;
        if (cp.size() > 0) {
            play = cp.get(rand.nextInt(cp.size()));
        } else {
            play = players.get(rand.nextInt(cp.size()));
        }
        lastPlayer = play;
        passedPlayer.add(play);
        return play;
    }

    public String getRandomName() {
        List<Player> list = new ArrayList<Player>(players);
        list.remove(lastPlayer);
        if (list.isEmpty()) {
            return RIP.toString();
        }
        Player play = list.get(rand.nextInt(list.size()));
        return play.getName().toString();
    }

    public Player getRandomName(Player remover) {
        List<Player> list = new ArrayList<Player>(players);
        list.remove(remover);
        if (list.isEmpty()) {
            return RIP;
        }
        Player play = list.get(rand.nextInt(list.size()));
        return play;
    }

    public String getBoy() {
        List<Player> list = new ArrayList<Player>(boys);

        list.remove(lastPlayer);

        if (list.isEmpty()) {
            return getRandomName();
        }

        Player play = list.get(rand.nextInt(list.size()));
        return play.getName().toString();
    }

    public String getGirl() {
        List<Player> list = new ArrayList<Player>(girls);

        list.remove(lastPlayer);

        if (list.isEmpty()) {
            return getRandomName();
        }

        Player play = list.get(rand.nextInt(list.size()));
        return play.getName().toString();
    }

    public Player getLastPlayer() {
        return lastPlayer;
    }

    public int getID() {
        return this.ID;
    }

    public void fillJson(InputStream input) throws IOException {

        InputStreamReader dataStreamReader = new InputStreamReader(input);

        BufferedReader dataBufferedReader = new BufferedReader(dataStreamReader);

        JsonReader data = new JsonReader(dataBufferedReader);

        data.beginObject();

        switch (data.nextName()) {
            case "actions":
                data.beginArray();
                while (data.hasNext()) {
                    actions.add(data.nextString());
                }
                data.endArray();
                break;

            case "verites":
                data.beginArray();
                while (data.hasNext()) {
                    verites.add(data.nextString());
                }
                data.endArray();
                break;

            case "transitionHomme":
                data.beginArray();
                while (data.hasNext()) {
                    transitionsH.add(data.nextString());
                }
                data.endArray();
                break;


            case "transitionFemme":
                data.beginArray();
                while (data.hasNext()) {
                    transitionsF.add(data.nextString());
                }
                data.endArray();
                break;

            case "duel":
                data.beginArray();
                while (data.hasNext()) {
                    duel.add(data.nextString());
                }
                data.endArray();
                break;
            case "minijeu":
                data.beginArray();
                while (data.hasNext()) {
                    minijeu.add(data.nextString());
                }
                data.endArray();
                break;
            case "global":
                data.beginArray();
                while (data.hasNext()) {
                    global.add(data.nextString());
                }
                data.endArray();
                break;
            case "dilem":
                data.beginArray();
                while (data.hasNext()) {
                    dilem.add(data.nextString());
                }
                data.endArray();
                break;
            case "role":
                data.beginArray();
                while (data.hasNext()) {
                    role.add(data.nextString());
                }
                data.endArray();
                break;

            default:
                break;

        }
        data.endObject();
    }

    public String getAction() {
        int r;
        if (actions.size() < 1) {
            actions.addAll(actionsTmp);
            r = 0;
        } else {
            r = rand.nextInt(actions.size());
        }
        String action;
        action = actions.get(r);
        actions.remove(r);
        actionsTmp.add(action);
        return action;
    }

    public String getVerite() {
        int r;
        if (verites.size() < 1) {
            verites.addAll(veritesTmp);
            r = 0;
        } else {
            r = rand.nextInt(verites.size());
        }
        String verite;
        verite = verites.get(r);
        verites.remove(r);
        veritesTmp.add(verite);
        return verite;
    }


    public String getDuel() {
        int r;
        if (duel.size() < 1) {
            duelBool = false;
            duel.addAll(duelTmp);
            r = 0;
        } else {
            r = rand.nextInt(duel.size());
        }
        String action;
        action = duel.get(r);
        duel.remove(r);
        duelTmp.add(action);
        return action;
    }


    public String getMiniJeu() {
        int r;
        if (minijeu.size() < 1) {
            minijeuBool = false;
            minijeu.addAll(minijeuTmp);
            r = 0;
        } else {
            r = rand.nextInt(minijeu.size());
        }

        String action;
        action = minijeu.get(r);
        minijeu.remove(r);
        minijeuTmp.add(action);
        return action;
    }

    public String getGlobal() {
        int r;
        if (global.size() < 1) {
            globalBool = false;
            global.addAll(globalTmp);
            r = 0;
        } else {
            r = rand.nextInt(global.size());
        }

        String action;
        action = global.get(r);
        global.remove(r);
        globalTmp.add(action);
        return action;
    }

    public String getDilem() {
        int r;
        if (dilem.size() < 1) {
            dilemBool = false;
            dilem.addAll(dilemTmp);
            r = 0;
        } else {
            r = rand.nextInt(dilem.size());
        }

        String action;
        action = dilem.get(r);
        dilem.remove(r);
        dilemTmp.add(action);
        return action;
    }

    public String getRole() {
        int r;
        if (role.size() < 1) {
            roleBool = false;
            role.addAll(roleTmp);
            r = 0;
        } else {
            r = rand.nextInt(role.size());
        }

        String action;
        action = role.get(r);
        role.remove(r);
        roleTmp.add(action);
        return action;
    }


    public String getTransition() {

        int r, r1;

        if (transitionsF.size() < 1) {
            transitionsF.addAll(transitionsFTmp);
            r = 0;
        } else {
            r = rand.nextInt(transitionsF.size());
        }

        if (transitionsH.size() < 1) {
            transitionsH.addAll(transitionsHTmp);
            r1 = 0;
        } else {
            r1 = rand.nextInt(transitionsH.size());
        }

        String transi;

        if (lastPlayer.isGenre() == true) {
            transi = transitionsH.get(r1);
            transitionsH.remove(r1);
            transitionsHTmp.add(transi);
        } else {
            transi = transitionsF.get(r);
            transitionsF.remove(r);
            transitionsFTmp.add(transi);
        }
        return transi;
    }


    public List<String> getVeritesList() {
        return verites;
    }

    public List<String> getActionsList() {
        return actions;
    }

    public List<String> getActionsTmp() {
        return actionsTmp;
    }

    public List<String> getVeritesTmp() {
        return veritesTmp;
    }

    public void clear() {
        players.clear();
        girls.clear();
        boys.clear();
        actionsTmp.clear();
        actions.clear();
        verites.clear();
        veritesTmp.clear();
        transitionsF.clear();
        transitionsH.clear();
        passedPlayer.clear();
        global.clear();
        minijeu.clear();
        duelTmp.clear();
        globalTmp.clear();
        minijeuTmp.clear();
        duelTmp.clear();
    }
}
