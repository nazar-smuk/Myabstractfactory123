package com.company;

public class Main implements Runnable{

    private final Kingdom kingdom = new Kingdom();

    public Kingdom getKingdom() {
        return kingdom;
    }

    public static void main(String[] args) {
        var app = new Main();
        app.run();
    }

    @Override
    public void run() {
        System.out.println("elf kingdom");
        createKingdom(Kingdom.FactoryMaker.KingdomType.ELF);
        System.out.println(kingdom.getArmy().getDescription());
        System.out.println(kingdom.getCastle().getDescription());
        System.out.println(kingdom.getKing().getDescription());

        System.out.println("orc kingdom");
        createKingdom(Kingdom.FactoryMaker.KingdomType.ORC);
        System.out.println(kingdom.getArmy().getDescription());
        System.out.println(kingdom.getCastle().getDescription());
        System.out.println(kingdom.getKing().getDescription());
    }

    /**
     * Creates kingdom.
     * @param kingdomType type of Kingdom
     */
    public void createKingdom(final Kingdom.FactoryMaker.KingdomType kingdomType) {
        final KingdomFactory kingdomFactory = Kingdom.FactoryMaker.makeFactory(kingdomType);
        kingdom.setKing(kingdomFactory.createKing());
        kingdom.setCastle(kingdomFactory.createCastle());
        kingdom.setArmy(kingdomFactory.createArmy());
    }
}
