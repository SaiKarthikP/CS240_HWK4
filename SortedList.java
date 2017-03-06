package cs240_hwk4;

public class SortedList<T extends Comparable<? super T>> implements SortedListInterface<T>{
private ListInterface<T> list;

public SortedList(){
list = new LList<T>();
} // end default constructor

public void add(T newEntry)
{
   int newPosition = Math.abs(getPosition(newEntry));
   list.add(newPosition, newEntry);
} // end add

public boolean remove(T anEntry)
{
   boolean result = false;
   int position = getPosition(anEntry);
   
   if (position > 0)
   {
      list.remove(position);
      result = true;
   } // end if
   
   return result;
} // end remove

public int getPosition(T anEntry)
{
   int position = 1;
   int length = list.getLength();
   
   // Find position of anEntry
   while ( (position <= length) &&
           (anEntry.compareTo(list.getEntry(position)) > 0) )
   {
      position++;
   } // end while
   
   // See whether anEntry is in list
   if ( (position > length) ||
        (anEntry.compareTo(list.getEntry(position)) != 0) )
   {
      position = -position; // anEntry is not in list
   } // end if
   
   return position;
} // end getPosition

public T getEntry(int givenPosition)
{
   return list.getEntry(givenPosition);
} // end getEntry

@Override
public boolean contains(T anEntry) {
	return list.contains(anEntry);
}

@Override
public T remove(int givenPosition) {
	return list.remove(givenPosition);
}

@Override
public void clear() {
	list.clear();
}

@Override
public int getLength() {
	return list.getLength();
	
}

@Override
public boolean isEmpty() {
	return list.isEmpty();
}

@Override
public T[] toArray() {
	return list.toArray();
}


}