package org.example;


import java.util.Stack;

public class SnapshotStringBuilder {

    private StringBuilder builder;
    private final Stack<Memento> undoMementos = new Stack<>();

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


    public SnapshotStringBuilder undo() {
        if(!undoMementos.isEmpty()){
            Memento memento = undoMementos.pop();
            builder = new StringBuilder(memento.state());
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
