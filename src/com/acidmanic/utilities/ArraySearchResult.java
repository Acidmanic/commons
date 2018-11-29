/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.utilities;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 *
 * This class can be used to contain the result of a search operation on an
 * array or any other kind of collection which is accessible by item indexes 
 * including <i>index:</i> index of found item in array,<i>found:</i> boolean
 * value indicating if the search was successfully found anything,
 * <i>searchItem:</i> the item that the array was searched against.
 *
 * @param <T> determines the class of items in the array or collection.
 */
public class ArraySearchResult<T> {

    private final boolean found;
    private final int index;
    private final T searchString;

    public ArraySearchResult() {
        this.found = false;
        this.index = -1;
        this.searchString = null;
    }

    public ArraySearchResult(int index, T searchItem) {
        this.found = true;
        this.index = index;
        this.searchString = searchItem;
    }

    public boolean isFound() {
        return found;
    }

    public int getIndex() {
        return index;
    }

    public T getSearchString() {
        return searchString;
    }

}
