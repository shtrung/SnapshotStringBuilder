package org.example;

import java.util.LinkedList;
import java.util.List;

public class SnapshotStringBuilder {

    private StringBuilder builder;
    private final List<Memento> undoMementos = new LinkedList<>();

    public SnapshotStringBuilder() {
        builder = new StringBuilder();
    }

    public SnapshotStringBuilder(String str){
        builder = new StringBuilder(str);
    }

    public SnapshotStringBuilder append(Object obj) {
        String object = String.valueOf(obj);
        saveState();
        return append(object);
    }

    public SnapshotStringBuilder append(String str) {
        saveState();
        builder.append(str);
        return this;
    }

    public SnapshotStringBuilder append(boolean b) {
        saveState();
        builder.append(b);
        return this;
    }
    public SnapshotStringBuilder append(long lng) {
        saveState();
        builder.append(lng);
        return this;
    }
    public SnapshotStringBuilder append(float f) {
        saveState();
        builder.append(f);
        return this;
    }
    public SnapshotStringBuilder append(int i) {
        saveState();
        builder.append(i);
        return this;
    }

    public SnapshotStringBuilder append(char c) {
        saveState();
        builder.append(c);
        return this;
    }
    public SnapshotStringBuilder append(double d) {
        saveState();
        builder.append(d);
        return this;
    }

    public SnapshotStringBuilder reverse(){
        saveState();
        builder.reverse();
        return this;
    }

    public SnapshotStringBuilder delete(int start, int end){
        saveState();
        builder.delete(start,end);
        return this;
    }

    private void saveState() {
        Memento memento = new Memento(builder.toString());
        undoMementos.add(memento);
    }

    public SnapshotStringBuilder undo(int stepBack) {
      if(stepBack==1){
          undo();
          return this;
      }else if(!undoMementos.isEmpty()){
          Memento memento = undoMementos.get(undoMementos.size()-stepBack);
          builder = new StringBuilder(memento.state());
          undoMementos.remove(memento);
          return this;
      }
      return this;
    }

    public SnapshotStringBuilder undo() {
        if(!undoMementos.isEmpty()){
            Memento memento = undoMementos.get(undoMementos.size()-1);
            builder = new StringBuilder(memento.state());
            undoMementos.remove(memento);
            return this;
        }
        return this;
    }

    public int length(){
        return builder.length();
    }

    public int compareTo(StringBuilder another) {
        return builder.compareTo(another);
    }

    @Override
    public String toString() {
        return builder.toString();
    }
}
