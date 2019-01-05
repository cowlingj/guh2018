public class Tank
{
  public KStream tankStream;
  public String friendOrFoe

  // One stream tracking our tank
  public Tank(KStream outputsStream);
  {
    KStream tankStream = new KStream filterIsEnemy(outputsStream);
     
    KStream nameTag = new KStream filterIsEnemy(tankStream);     
    
  } // Tank

  
  private static KStream filterIsTank(KStream stream)
  {
    return KStream outputsStream.filter((type.id.equals(Id, "tank"), Id, Value);

  } // filterIsTank

  private static KStream filterIsEnemy(KStream stream)
  {
   return KStream outputsStream.filter((type.id.equals(Id, "name"),
                  Id, Value);  

  } // filterIsEnemy

} // TankStreams
