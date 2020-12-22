package edu.umb.cs681.hw21;

import java.util.stream.Collectors;

import java.util.*;

public class BarclaysPremierLeague {

    public BarclaysPremierLeague(String teamName, String manager, int yearEst, int netWorth, int titles) {
        super();
        this.manager = manager;
        this.teamName = teamName;
        this.yearEst = yearEst;
        this.netWorth = netWorth;
        this.titles = titles;
    }

    private int titles, yearEst;
    private float netWorth;

    private String manager, teamName;


    public void setManager(String manager) {
        this.manager = manager;
    }

    public void setNetWorth(float netWorth) {
        this.netWorth = netWorth;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void setYearEst(int yearEst) {
        this.yearEst = yearEst;
    }

    public void setTitles(int titles) {
        this.titles = titles;
    }

    public String getTeamName() {
        return teamName;
    }

    public int getTitles() {
        return titles;
    }

    public int getYearEst() {
        return yearEst;
    }

    public String getManager() {
        return manager;
    }

    public float getNetWorth() {
        return netWorth;
    }

    @Override
    public String toString() {

        return this.manager + " " + this.teamName + " " + this.titles + " " + this.yearEst + " " + this.netWorth;
    }

    public static void main(String args[]) {
        List<BarclaysPremierLeague> teamList = new ArrayList<BarclaysPremierLeague>();

        teamList.add(new BarclaysPremierLeague("Hotspurs", "Rajput", 1910, 20000, 10));
        teamList.add(new BarclaysPremierLeague("Liverpool", "FrankLampard", 1856, 15000, 6));
        teamList.add(new BarclaysPremierLeague("ManchesterUnited", "OleGunnarSolskjær", 1850, 600000, 7));
        teamList.add(new BarclaysPremierLeague("ManCity", "PepGuardiola", 1920, 5000, 3));
        teamList.add(new BarclaysPremierLeague("Chelsea", "Vishiboy", 1892, 20100, 10));

        Float maximumNetWorth = teamList.stream().parallel().map((BarclaysPremierLeague team) -> team.getNetWorth()).reduce((float) 0,(result, netWorth) -> {
            if (result == 0) {
                return netWorth;
            }
            else if (netWorth > result) {
                return netWorth;
            }
            else {
                return result;
            }
        });
        System.out.println("The minimum netWorth among all the teams is : " + maximumNetWorth);

        int minimumTitles = teamList.stream().parallel().map((BarclaysPremierLeague team) -> team.getTitles()).reduce((0),(result, titles) -> {
            if (result == 0) {
                return titles;
            }
            else if (titles < result) {
                return titles;
            }
            else {
                return result;
            }
        });
        System.out.println("The min titles won by a team is : " + minimumTitles);


    }
}