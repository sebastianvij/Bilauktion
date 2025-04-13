package BidComparators;

import model.Bid;
import java.util.Comparator;

public class BidderNameComparator implements Comparator<Bid> {
    @Override
    public int compare(Bid bid1, Bid bid2) {
        return bid1.getBidderName().compareToIgnoreCase(bid2.getBidderName());
    }
}
