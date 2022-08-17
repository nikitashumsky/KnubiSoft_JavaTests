package com.knubisoft.base.list;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListTasksImpl implements ListTasks {
    @Override
    public List<String> addElements(String... elements) {
        List<String> listOfEl = new ArrayList<>();
        for (String element : elements) {
            listOfEl.add(element);
        }
        return listOfEl;
    }

    @Override
    public List<String> getElementsByIndexes(List<String> elements, int[] indexes) {
        List<String> listOfNewEl = new ArrayList<>();
        listOfNewEl.addAll(elements);
        try {
            for (int i = 0; i < indexes.length; i++) {
                int num = indexes[i];
                if (listOfNewEl.contains(listOfNewEl.get(num))) {
                    listOfNewEl.add(listOfNewEl.get(num));
                }
            }
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        return listOfNewEl;
    }

    @Override
    public ArrayList<String> addElementsByIndexes(ArrayList<String> elements, int[] indexes) {
        ArrayList<String> listOfNewEl = new ArrayList<>();
        listOfNewEl.addAll(elements);
        try {
            for (int i = 0; i < indexes.length; i++) {
                int num = indexes[i];
                if (listOfNewEl.contains(listOfNewEl.get(num))) {
                    listOfNewEl.add(num, listOfNewEl.get(num));
                }
            }
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        return listOfNewEl;
    }

    @Override
    public LinkedList<String> setElementsByIndexes(LinkedList<String> elements, int[] indexes) {
        LinkedList<String> listOfNewEl = new LinkedList<>();
        listOfNewEl.addAll(elements);
        try {
            for (int i = 0; i < indexes.length; i++) {
                int num = indexes[i];
                if (listOfNewEl.contains(listOfNewEl.get(num))) {
                    listOfNewEl.set(num, listOfNewEl.get(num));
                }
            }
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        return listOfNewEl;
    }

    @Override
    public int getListSize(List<String> list) {
        int size;
        try {
            size = list.size();
        } catch (NullPointerException e) {
            return 0;
        }
        return size;
    }

    @Override
    public List<Long> merge(List<Integer> first, List<Long> second, List<String> third) {
        List<Long> mergedList = new ArrayList<>();
        if (third.contains(null)) {
            throw new NullPointerException();
        }
        for (long element : first) {
            mergedList.add(element);
        }
        mergedList.addAll(second);
        for (String element : third) {
            mergedList.add(Long.parseLong(element));
        }
        return mergedList;
    }

    @Override
    public int findMaxValue(List<Integer> first, List<Integer> second, List<Integer> third) {
        int firstMax = 0;
        int secondMax = 0;
        int thirdMax = 0;
        for (int i : first) {
            if (firstMax < i) {
                firstMax = i;
            }
        }
        for (int i : second) {
            if (secondMax < i) {
                secondMax = i;
            }
        }
        for (int i : third) {
            if (thirdMax < i) {
                thirdMax = i;
            }
        }
        if (firstMax > secondMax && firstMax > thirdMax) {
            return firstMax;
        } else if (secondMax > firstMax && secondMax > thirdMax) {
            return secondMax;
        } else
            return thirdMax;
    }

    @Override
    public int findMinValue(List<Integer> first, List<Integer> second, List<Integer> third) {
        int firstMin = 0;
        int secondMin = 0;
        int thirdMin = 0;
        for (int i : first) {
            if (firstMin > i) {
                firstMin = i;
            }
        }
        for (int i : second) {
            if (secondMin > i) {
                secondMin = i;
            }
        }
        for (int i : third) {
            if (thirdMin > i) {
                thirdMin = i;
            }
        }
        if (firstMin < secondMin && firstMin < thirdMin) {
            return firstMin;
        } else if (secondMin < firstMin && secondMin < thirdMin) {
            return secondMin;
        } else
            return thirdMin;
    }

    @Override
    public int multiplyMax2Elements(List<Integer> first, List<Integer> second, List<Integer> third) {
        int firstMax = first.get(0);
        int secondMax = second.get(0);
        for (int i : first) {
            if (firstMax < i) {
                firstMax = i;
                if (secondMax < firstMax && secondMax < i)
                    secondMax = i;
            }
        }
        for (int i : second) {
            if (firstMax < i) {
                firstMax = i;
                if (secondMax < firstMax && secondMax < i)
                    secondMax = i;
            }
        }
        for (int i : third) {
            if (firstMax < i) {
                firstMax = i;
                if (secondMax < firstMax && secondMax < i)
                    secondMax = i;
            }
        }
        return firstMax * secondMax;
    }

    @Override
    public List<String> removeNulls(List<String> list) {
        List<String> listWithoutNulls = new ArrayList<>();
        listWithoutNulls.addAll(list);
        for (int i = 0; i < listWithoutNulls.size(); i++){
                if (listWithoutNulls.get(i) == null) {
                    listWithoutNulls.remove(listWithoutNulls.get(i));
                }
        }
        return listWithoutNulls;
    }

    @Override
    public List<Integer> flatMapWithoutNulls(List<List<Integer>> list) {
        if (list == null){
            throw new NoSuchElementException();
        }
        return list.stream()
                .flatMap(Collection::stream)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    @Override
    public List<Integer> cloneIds(List<Integer> originalIds) {
        if (originalIds == null){
            throw new NoSuchElementException();
        }
        return new ArrayList<>(originalIds)
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> shuffle(List<String> originalStrings) {
        if (originalStrings == null){
            throw new RuntimeException();
        }
        if (originalStrings.isEmpty()){
            return originalStrings;
        }
        Random rand = new Random();
        for (int i = 0; i < originalStrings.size(); i++) {
            int randomIndexToSwap = rand.nextInt(originalStrings.size());
            String temp = originalStrings.get(randomIndexToSwap);
            originalStrings.set(randomIndexToSwap, originalStrings.get(i));
            originalStrings.set(i, temp);
        }
        //Collections.shuffle(originalStrings);
        return originalStrings;
    }

    @Override
    public String getLastElement(LinkedList<String> list) {
        if (list == null){
            throw new NoSuchElementException();
        }
        if (list.isEmpty()){
            return "";
        }
        //return list.peekLast();
        return list.get(list.size()-1);
    }

    @Override
    public List<String> compareElements(LinkedList<String> originalCollection, LinkedList<String> additionalCollection) {
        if (originalCollection == null || additionalCollection == null){
            throw new IllegalArgumentException();
        }
        List<String> result = new ArrayList<>();
        for (String s : originalCollection){
            if (additionalCollection.contains(s)){
                result.add(s);
            }
        }
        //originalCollection.retainAll(additionalCollection);
        //return originalCollection;
        return result;
    }
}
