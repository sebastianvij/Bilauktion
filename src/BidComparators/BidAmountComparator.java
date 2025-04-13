package BidComparators;

import model.Bid;

import java.util.Comparator;

public class BidAmountComparator implements Comparator<Bid> {
    @Override
    public int compare(Bid bid1, Bid bid2) {
        return Double.compare(bid1.getAmount(), bid2.getAmount());
    }
}
