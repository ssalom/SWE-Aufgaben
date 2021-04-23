/*
 * Projekt: ExpeditionManager
 * Firma:   ABB TS
 * Autor:   M. Bontognali
 *
 * Beschreibung: 
 * Diese Klasse verwaltet Container. Dabei hat jeder Container eine andere
 * Kombination von Gegenständen.
 */

import java.util.*;

public class Combinations {
  private List<Container> containers;
  
  public Combinations() {
    containers = new ArrayList<>();
  }
  
  public void add(Container container) {
    containers.add(container);
  }
  
  public void add(Combinations combinations) {
    containers.addAll(combinations.getContainers());
  }
  
  public List<Container> getContainers() {
    return containers;
  }

  public String toString() {
    StringBuilder text = new StringBuilder(1000);
    for(Container container : containers) {
      text.append(container.toString() + "\n");
    }
    return text.toString();
  }  
  
  public Combinations clone() {
    Combinations combinations = new Combinations();
    for(Container container : containers) {
      combinations.add(container.clone());
    }
    return combinations;
  }
}
