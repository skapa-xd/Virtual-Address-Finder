public class VirtualAddressInfo 
{
    public long pageNumber;
    public int offset;
    public VirtualAddressInfo(long pageNumber, int offset)
    {
        this.pageNumber = pageNumber;
        this.offset = offset;
    }

    public long getPageNumber()
    {
        return pageNumber;
    }
    public int getOffSet()
    {
        return offset;
    };
    
}
