public class Loja {
	static Jogos[] jogos = new Jogos[5];
	Loja()
	{
		for(int i = 0; i < 5; i++)
		{
			jogos[i] = new Jogos();
		}
		jogos[0].titulo = "HollowKnight";
		jogos[1].titulo = "DarkSouls";
		jogos[2].titulo = "SilentHill";
		jogos[3].titulo = "Left4Dead";
		jogos[4].titulo = "CS:GO";
	}
}
